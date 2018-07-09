package com.devlink.network.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.devlink.dao.Frd;

public interface NetMapper {
	ArrayList<Frd> selectFrdTo(String no);
	ArrayList<Frd> selectFrdFrom(String no);
	ArrayList<Frd> selectFrdP(String no);
	ArrayList<Frd> selectFrd(String no);
	ArrayList<Frd> selectFrdAll(String no);
	HashMap<String, String> selectIngFrdNo(HashMap<String, String> map);
	void deleteFrdFrom(String frdNo);
	HashMap<String, String> isFrd(HashMap<String, String> map);
	void updateFrdtoOk(String frdNo);
}