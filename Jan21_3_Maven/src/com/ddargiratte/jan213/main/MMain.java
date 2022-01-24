package com.ddargiratte.jan213.main;

import org.json.simple.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import com.ddargiratte.db.manager.DdargiratteDBManager;
import com.ddargiratte.dec2244.HttpClient.DdargiratteHttpClient;

// Java 전 세계적으로 많이 사용
//	개발자들이 본인이 만들어 놓은 것들을 공유!
//	소스 자체를 공유 x, .jar파일 만들어서 공유하는 문화 o
//	.jar파일을 자동으로 관리해주는 시스템 : Maven
//	Maven의 중앙 저장소 : https://mvnrepository.com/

// Maven을 활용하면
//	Maven 중앙 저장소에 있는 .jar파일 
//	컴퓨터의 Maven로컬 저장소

// Maven 중앙 저장소에 없는 것들 : 로컬 저장소를 활용하면 됨!
//	우리가 만든 보물들.. dbm, hc, ...

public class MMain {
	public static void main(String[] args) {
		XmlPullParser xpp;
		JSONObject jo;	// 자동완성 돼야해요! 보물 등록 ㄱㄱ
		DdargiratteHttpClient dhc;	// 자동완성되면 성공~~ 옆에 창 저장 하고 해야해요~
		DdargiratteDBManager ddb;	// 자동완성 안뜨면 업데이트 눌러봐요오
	}
}