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

package com.liferay.portal.service.persistence;


/**
 * <a href="LayoutPrototypePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LayoutPrototypePersistenceImpl
 * @see       LayoutPrototypeUtil
 * @generated
 */
public interface LayoutPrototypePersistence extends BasePersistence {
	public void cacheResult(
		com.liferay.portal.model.LayoutPrototype layoutPrototype);

	public void cacheResult(
		java.util.List<com.liferay.portal.model.LayoutPrototype> layoutPrototypes);

	public void clearCache();

	public com.liferay.portal.model.LayoutPrototype create(
		long layoutPrototypeId);

	public com.liferay.portal.model.LayoutPrototype remove(
		long layoutPrototypeId)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype remove(
		com.liferay.portal.model.LayoutPrototype layoutPrototype)
		throws com.liferay.portal.SystemException;

	/**
	 * @deprecated Use {@link #update(LayoutPrototype, boolean merge)}.
	 */
	public com.liferay.portal.model.LayoutPrototype update(
		com.liferay.portal.model.LayoutPrototype layoutPrototype)
		throws com.liferay.portal.SystemException;

	/**
	 * Add, update, or merge, the entity. This method also calls the model
	 * listeners to trigger the proper events associated with adding, deleting,
	 * or updating an entity.
	 *
	 * @param  layoutPrototype the entity to add, update, or merge
	 * @param  merge boolean value for whether to merge the entity. The default
	 *         value is false. Setting merge to true is more expensive and
	 *         should only be true when layoutPrototype is transient. See
	 *         LEP-5473 for a detailed discussion of this method.
	 * @return the entity that was added, updated, or merged
	 */
	public com.liferay.portal.model.LayoutPrototype update(
		com.liferay.portal.model.LayoutPrototype layoutPrototype, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype updateImpl(
		com.liferay.portal.model.LayoutPrototype layoutPrototype, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype findByPrimaryKey(
		long layoutPrototypeId)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype fetchByPrimaryKey(
		long layoutPrototypeId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype findByCompanyId_First(
		long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype findByCompanyId_Last(
		long companyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype[] findByCompanyId_PrevAndNext(
		long layoutPrototypeId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findByC_A(
		long companyId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype findByC_A_First(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype findByC_A_Last(
		long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public com.liferay.portal.model.LayoutPrototype[] findByC_A_PrevAndNext(
		long layoutPrototypeId, long companyId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.NoSuchLayoutPrototypeException,
			com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portal.model.LayoutPrototype> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.SystemException;

	public void removeByC_A(long companyId, boolean active)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByCompanyId(long companyId)
		throws com.liferay.portal.SystemException;

	public int countByC_A(long companyId, boolean active)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}