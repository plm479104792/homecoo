package com.homecoo.smarthome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homecoo.smarthome.domain.AppVersion;
import com.homecoo.smarthome.domain.Theme;
import com.homecoo.smarthome.persistence.AppVersionMapper;
import com.homecoo.smarthome.persistence.ThemeMapper;
import com.homecoo.smarthome.service.ITheme;

@Service
public class ThemeServiceImpl implements ITheme{

	@Autowired
	private ThemeMapper themeMapper;
	
	@Autowired
	private AppVersionMapper appVersionMapper;
	
	@Override
	public int addTheme(Theme theme) {
		int row=themeMapper.insertTheme(theme);
		return row;
	}

	@Override
	public int updateTheme(Theme theme) {
		System.out.println(" themeserviceImpl    "+theme.toString());
		int row=themeMapper.updateTheme(theme);
		return row;
	}

	@Override
	public int deleteTheme(String gatewayNo) {
		int row=themeMapper.deleteTheme(gatewayNo);
		return row;
	}

	@Override
	public List<Theme> getAllTheme(String gatewayNo) {
		List<Theme> list=themeMapper.selectAllThemeByPhoneNum(gatewayNo);
		return list;
	}

	
	//张老师写的情景
	@Override
	public void addTheme(String themePacket, String gatewayNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTheme(String themeNo) {
		List<Theme> list=themeMapper.selectThemeByThemeNoGatewayNo(themeNo);
		if (list.size() > 0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public AppVersion getAppVersionByPhoneNumVersionType(AppVersion appVersion) {
		AppVersion version=appVersionMapper.getAppVersionByPhoneNumVersionType(appVersion);
		return version;
	}

	@Override
	public int updateVersion(AppVersion appVersion) {
		int row=appVersionMapper.updateAppVersion(appVersion);
		return row;
	}

	@Override
	public int addAppVersion(AppVersion appVersion) {
		int row=appVersionMapper.addAppVersion(appVersion);
		return row;
	}

	@Override
	public AppVersion getAppVersionByGatewayNoVersionType(AppVersion appVersion) {
		AppVersion version=appVersionMapper.getAppVersionByGatewayNoVersionType(appVersion);
		return version;
	}

	@Override
	public int deleteAppVersion(String phonenum,Integer type) {
		AppVersion appVersion=new AppVersion();
		appVersion.setPhoneNum(phonenum);
		appVersion.setVersionType(type);
		int row=appVersionMapper.deleteAppVersion(appVersion);
		return row;
	}

}
