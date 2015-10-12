package model;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class SlotFactory {

	public static Slot generateSlot(String address, String command) {
		if (command.startsWith("#")) {
			return new CommentSlot(address, command.substring(1));
		} else if (command.contains(address)) {
			return new CircularSlot(address, command);
		} else {
			ExprParser ex = new ExprParser();
			Expr expr = null;
			try {
				expr = ex.build(command);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new ExprSlot(address, expr);
		}
	}
}
