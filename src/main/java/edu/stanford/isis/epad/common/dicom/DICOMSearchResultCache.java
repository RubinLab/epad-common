/*
 * Copyright 2012 The Board of Trustees of the Leland Stanford Junior University.
 * Author: Daniel Rubin, Alan Snyder, Debra Willrett. All rights reserved. Possession
 * or use of this program is subject to the terms and conditions of the Academic
 * Software License Agreement available at:
 *   http://epad.stanford.edu/license/
 */
package edu.stanford.isis.epad.common.dicom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Caches DICOMSearchResults.
 * 
 * @author amsnyder
 */
public class DICOMSearchResultCache
{
	private static DICOMSearchResultCache ourInstance = new DICOMSearchResultCache();

	private final Map<SearchKey, DICOMSearchResultImpl> cache = new ConcurrentHashMap<SearchKey, DICOMSearchResultImpl>();
	private final Map<SearchKey, Long> cacheTimestamp = new ConcurrentHashMap<SearchKey, Long>();
	private final Map<UserKey, DICOMSearchResultImpl> mostRecent = new ConcurrentHashMap<UserKey, DICOMSearchResultImpl>();

	public static DICOMSearchResultCache getInstance()
	{
		return ourInstance;
	}

	private DICOMSearchResultCache()
	{
	}

	/**
	 * Cache a new SearchResult
	 * 
	 * @param searchResult
	 * @param searchType
	 * @param searchParam
	 */
	public void cache(DICOMSearchResultImpl searchResult, DicomStudySearchType searchType, String searchParam)
	{
		SearchKey key = new SearchKey(searchType, searchParam);
		cache.put(key, searchResult);
		cacheTimestamp.put(key, System.currentTimeMillis());
	}

	/**
	 * 
	 * @param remoteAddr
	 * @return
	 */
	public DICOMSearchResultImpl getMostRecent(String remoteAddr)
	{
		UserKey key = new UserKey(remoteAddr);
		return mostRecent.get(key);
	}

	class SearchKey
	{
		final DicomStudySearchType type;
		final String param;

		public SearchKey(DicomStudySearchType searchType, String searchParam)
		{
			type = searchType;
			param = searchParam;
		}

		@Override
		public boolean equals(Object o)
		{
			if (o == this)
				return true;
			if (!(o instanceof SearchKey))
				return false;

			SearchKey sk = (SearchKey)o;

			return sk.type == type && sk.param.equals(param);
		}

		@Override
		public int hashCode()
		{
			int result = 13;
			result = 17 * result + type.hashCode();
			result = 19 * result + param.hashCode();
			return result;
		}

	}

	/**
	 * Key used to identify an unique user.
	 */
	class UserKey
	{

		final String userId;

		public UserKey(String remoteAddr)
		{
			userId = remoteAddr;
		}

		@Override
		public boolean equals(Object o)
		{
			if (o == this)
				return true;
			if (!(o instanceof UserKey))
				return false;

			UserKey uk = (UserKey)o;

			return userId.equals(uk.userId);
		}

		@Override
		public int hashCode()
		{
			return userId.hashCode() * 7;
		}
	}// class UserKey

	/**
	 * Use for debugging.
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{

		int nCache = cache.size();
		int nTimestamp = cacheTimestamp.size();
		int nMostRecent = mostRecent.size();

		StringBuilder sb = new StringBuilder();
		sb.append(", cache.size: ").append(nCache);
		sb.append(", timestamp.size: ").append(nTimestamp);
		sb.append(", mostRecent.size: ").append(nMostRecent);

		return sb.toString();
	}

}
