/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.blogs.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="BlogsEntrySoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * {@link com.liferay.portlet.blogs.service.http.BlogsEntryServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.blogs.service.http.BlogsEntryServiceSoap
 * @generated
 */
public class BlogsEntrySoap implements Serializable {
	public static BlogsEntrySoap toSoapModel(BlogsEntry model) {
		BlogsEntrySoap soapModel = new BlogsEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setUrlTitle(model.getUrlTitle());
		soapModel.setContent(model.getContent());
		soapModel.setDisplayDate(model.getDisplayDate());
		soapModel.setDraft(model.getDraft());
		soapModel.setAllowTrackbacks(model.getAllowTrackbacks());
		soapModel.setTrackbacks(model.getTrackbacks());

		return soapModel;
	}

	public static BlogsEntrySoap[] toSoapModels(BlogsEntry[] models) {
		BlogsEntrySoap[] soapModels = new BlogsEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BlogsEntrySoap[][] toSoapModels(BlogsEntry[][] models) {
		BlogsEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BlogsEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BlogsEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BlogsEntrySoap[] toSoapModels(List<BlogsEntry> models) {
		List<BlogsEntrySoap> soapModels = new ArrayList<BlogsEntrySoap>(models.size());

		for (BlogsEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BlogsEntrySoap[soapModels.size()]);
	}

	public BlogsEntrySoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getUrlTitle() {
		return _urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public Date getDisplayDate() {
		return _displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		_displayDate = displayDate;
	}

	public boolean getDraft() {
		return _draft;
	}

	public boolean isDraft() {
		return _draft;
	}

	public void setDraft(boolean draft) {
		_draft = draft;
	}

	public boolean getAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public boolean isAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public void setAllowTrackbacks(boolean allowTrackbacks) {
		_allowTrackbacks = allowTrackbacks;
	}

	public String getTrackbacks() {
		return _trackbacks;
	}

	public void setTrackbacks(String trackbacks) {
		_trackbacks = trackbacks;
	}

	private String _uuid;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _urlTitle;
	private String _content;
	private Date _displayDate;
	private boolean _draft;
	private boolean _allowTrackbacks;
	private String _trackbacks;
}