package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import model.expr.Environment;
import model.expr.Expr;

public class Sheet extends Observable implements Environment{
	private Map<String, Expr> sheet;
	
	
	public Sheet(){
		sheet = new HashMap<String, Expr>();
	}
	
	public void save(){
	}
	
	public void load(String fileName){
	}
	
	public void put(String s, Expr expr){
		sheet.put(s, expr);
	}
	
	public void replace(String s, Expr expr){
		sheet.replace(s, expr);
	}
	
	public void remove(String s){
		sheet.remove(s);
	}
	
	public Expr getExpr(String s){
		return sheet.get(s);
	}
	
	@Override
	public double value(String name) {
		return 0;
	}

}
