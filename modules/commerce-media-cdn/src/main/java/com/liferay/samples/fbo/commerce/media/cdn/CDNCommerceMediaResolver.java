package com.liferay.samples.fbo.commerce.media.cdn;

import com.liferay.commerce.media.CommerceMediaResolver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"service.ranking:Integer=100"
		},		
		service = CommerceMediaResolver.class
		)
public class CDNCommerceMediaResolver implements CommerceMediaResolver {

	@Reference  (
			target = "(component.name=com.liferay.commerce.media.internal.DefaultCommerceMediaResolver)"
			)
	private CommerceMediaResolver _defaultCommerceMediaResolver;

	private String HOST_URL = "http://cdn:8080"; 
	
	@Override
	public String getDefaultUrl(long groupId) {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getDefaultUrl(groupId));
		return sb.toString();
	}

	@Override
	public String getDownloadUrl(long cpAttachmentFileEntryId) throws PortalException {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getDownloadUrl(cpAttachmentFileEntryId));
		return sb.toString();
	}

	@Override
	public byte[] getMediaBytes(HttpServletRequest httpServletRequest) throws IOException, PortalException {
		return _defaultCommerceMediaResolver.getMediaBytes(httpServletRequest);
	}

	@Override
	public String getThumbnailUrl(long cpAttachmentFileEntryId) throws PortalException {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getThumbnailUrl(cpAttachmentFileEntryId));
		return sb.toString();
	}

	@Override
	public String getUrl(long cpAttachmentFileEntryId) throws PortalException {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getUrl(cpAttachmentFileEntryId));
		return sb.toString();
	}

	@Override
	public String getUrl(long cpAttachmentFileEntryId, boolean download, boolean thumbnail) throws PortalException {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getUrl(cpAttachmentFileEntryId, download, thumbnail));
		return sb.toString();
	}

	@Override
	public String getUrl(long cpAttachmentFileEntryId, boolean download, boolean thumbnail, boolean secure)
			throws PortalException {
		StringBundler sb = new StringBundler(2);
		sb.append(HOST_URL);
		sb.append(_defaultCommerceMediaResolver.getUrl(cpAttachmentFileEntryId, download, thumbnail, secure));
		return sb.toString();
	}

	@Override
	public void sendMediaBytes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws IOException {
		_defaultCommerceMediaResolver.sendMediaBytes(httpServletRequest, httpServletResponse);
	}

	@Override
	public void sendMediaBytes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String download) throws IOException {
		_defaultCommerceMediaResolver.sendMediaBytes(httpServletRequest, httpServletResponse, download);
	}
	
}
