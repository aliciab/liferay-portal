/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.documentlibrary.util;

import com.liferay.portal.kernel.bean.BeanParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Iván Zaera
 */
public class DLFileEntryActionsDisplayContext {

	public DLFileEntryActionsDisplayContext(
			HttpServletRequest request, FileEntry fileEntry)
		throws PortalException, SystemException {

		this(request, fileEntry, fileEntry.getFileVersion());
	}

	public DLFileEntryActionsDisplayContext(
		HttpServletRequest request, FileEntry fileEntry,
		FileVersion fileVersion) {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		_companyId = themeDisplay.getCompanyId();

		_fileEntryTypeId = ParamUtil.getLong(request, "fileEntryTypeId", -1);

		if ((_fileEntryTypeId == -1) && (fileEntry != null) &&
			(fileEntry.getModel() instanceof DLFileEntry)) {

			DLFileEntry dlFileEntry = (DLFileEntry)fileEntry.getModel();

			_fileEntryTypeId = dlFileEntry.getFileEntryTypeId();
		}

		_folderId = BeanParamUtil.getLong(fileEntry, request, "folderId");
		_permissionChecker = themeDisplay.getPermissionChecker();
		_scopeGroupId = themeDisplay.getScopeGroupId();

		_dlFileEntryActionsDisplayContextHelper =
			new DLFileEntryActionsDisplayContextHelper(
				_permissionChecker, fileEntry, fileVersion);

		_dlActionsDisplayContext = new DLActionsDisplayContext(request);
	}

	public String getPublishButtonLabel() throws SystemException {
		String publishButtonLabel = "publish";

		if (_hasWorkflowDefinitionLink()) {
			publishButtonLabel = "submit-for-publication";
		}

		if (_isFileEntrySaveAsDraft()) {
			publishButtonLabel = "save";
		}

		return publishButtonLabel;
	}

	public String getSaveButtonLabel() {
		String saveButtonLabel = "save";

		FileVersion fileVersion =
			_dlFileEntryActionsDisplayContextHelper.getFileVersion();

		if ((fileVersion == null) ||
			_dlFileEntryActionsDisplayContextHelper.isApproved() ||
			_dlFileEntryActionsDisplayContextHelper.isDraft()) {

			saveButtonLabel = "save-as-draft";
		}

		return saveButtonLabel;
	}

	public boolean isCancelCheckoutDocumentButtonDisabled() {
		return false;
	}

	public boolean isCancelCheckoutDocumentButtonVisible()
		throws PortalException, SystemException {

		if (isCheckinButtonVisible() ||
			(_dlFileEntryActionsDisplayContextHelper.isCheckedOut() &&
			 _dlFileEntryActionsDisplayContextHelper.
				 hasOverrideCheckoutPermission())) {

			return true;
		}

		return false;
	}

	public boolean isCheckinButtonDisabled() {
		return false;
	}

	public boolean isCheckinButtonVisible()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasUpdatePermission() &&
			_dlFileEntryActionsDisplayContextHelper.isLockedByMe() &&
			_dlFileEntryActionsDisplayContextHelper.isSupportsLocking()) {

			return true;
		}

		return false;
	}

	public boolean isCheckoutDocumentButtonVisible()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasUpdatePermission() &&
			!_dlFileEntryActionsDisplayContextHelper.isCheckedOut() &&
			_dlFileEntryActionsDisplayContextHelper.isSupportsLocking()) {

			return true;
		}

		return false;
	}

	public boolean isCheckoutDocumentDisabled() {
		return false;
	}

	public boolean isDeleteButtonVisible()
		throws PortalException, SystemException {

		if (_isFileEntryDeletable() && !_isFileEntryTrashable()) {
			return true;
		}

		return false;
	}

	public boolean isDownloadButtonVisible()
		throws PortalException, SystemException {

		return _dlFileEntryActionsDisplayContextHelper.hasViewPermission();
	}

	public boolean isEditButtonVisible()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasUpdatePermission() &&
			!_isFileEntryCheckedOutByOther()) {

			return true;
		}

		return false;
	}

	public boolean isMoveButtonVisible()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasUpdatePermission() &&
			!_isFileEntryCheckedOutByOther()) {

			return true;
		}

		return false;
	}

	public boolean isMoveToTheRecycleBinButtonVisible()
		throws PortalException, SystemException {

		if (!isDeleteButtonVisible() && _isFileEntryDeletable()) {
			return true;
		}

		return false;
	}

	public boolean isOpenInMsOfficeButtonVisible()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasViewPermission() &&
			_dlFileEntryActionsDisplayContextHelper.isOfficeDoc() &&
			_dlActionsDisplayContext.isWebDAVEnabled() &&
			_dlActionsDisplayContext.isIEOnWin32()) {

			return true;
		}

		return false;
	}

	public boolean isPermissionsButtonVisible()
		throws PortalException, SystemException {

		return
			_dlFileEntryActionsDisplayContextHelper.hasPermissionsPermission();
	}

	public boolean isPublishButtonDisabled() {
		if ((_dlFileEntryActionsDisplayContextHelper.isCheckedOut() &&
			 !_dlFileEntryActionsDisplayContextHelper.isLockedByMe()) ||
			(_dlFileEntryActionsDisplayContextHelper.isPending() &&
			 _isDLFileEntryDraftsEnabled())) {

			return true;
		}

		return false;
	}

	public boolean isPublishButtonVisible() {
		return true;
	}

	public boolean isSaveButtonDisabled() {
		if (_dlFileEntryActionsDisplayContextHelper.isCheckedOut() &&
			!_dlFileEntryActionsDisplayContextHelper.isLockedByMe()) {

			return true;
		}

		return false;
	}

	public boolean isSaveButtonVisible() {
		return _isDLFileEntryDraftsEnabled();
	}

	public boolean isViewButtonVisible()
		throws PortalException, SystemException {

		return _dlFileEntryActionsDisplayContextHelper.hasViewPermission();
	}

	public boolean isViewOriginalFileButtonVisible()
		throws PortalException, SystemException {

		return _dlFileEntryActionsDisplayContextHelper.hasViewPermission();
	}

	private boolean _hasWorkflowDefinitionLink() throws SystemException {
		try {
			return DLUtil.hasWorkflowDefinitionLink(
				_companyId, _scopeGroupId, _folderId, _fileEntryTypeId);
		}
		catch (Exception e) {
			throw new SystemException(
				"Unable to check if file entry has workflow definition link",
				e);
		}
	}

	private boolean _isDLFileEntryDraftsEnabled() {
		return PropsValues.DL_FILE_ENTRY_DRAFTS_ENABLED;
	}

	private boolean _isFileEntryCheckedOutByOther() {
		if (_dlFileEntryActionsDisplayContextHelper.isCheckedOut() &&
			!_dlFileEntryActionsDisplayContextHelper.isLockedByMe()) {

			return true;
		}

		return false;
	}

	private boolean _isFileEntryDeletable()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.hasDeletePermission() &&
			!_isFileEntryCheckedOutByOther()) {

			return true;
		}

		return false;
	}

	private boolean _isFileEntrySaveAsDraft() {
		if ((_dlFileEntryActionsDisplayContextHelper.isCheckedOut() ||
			 _dlFileEntryActionsDisplayContextHelper.isPending()) &&
			!_isDLFileEntryDraftsEnabled()) {

			return true;
		}

		return false;
	}

	private boolean _isFileEntryTrashable()
		throws PortalException, SystemException {

		if (_dlFileEntryActionsDisplayContextHelper.isDLFileEntry() &&
			_dlActionsDisplayContext.isTrashEnabled()) {

			return true;
		}

		return false;
	}

	private long _companyId;
	private DLActionsDisplayContext _dlActionsDisplayContext;
	private DLFileEntryActionsDisplayContextHelper
		_dlFileEntryActionsDisplayContextHelper;
	private long _fileEntryTypeId;
	private long _folderId;
	private PermissionChecker _permissionChecker;
	private long _scopeGroupId;

}