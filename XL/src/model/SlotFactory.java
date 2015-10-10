package model;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;

public class SlotFactory {

	public static Slot generateSlot(String command, String address) {
		if (command.startsWith("#")) {
			return new CommentSlot(new Comment(command.substring(1)), address);
		} else if (command.contains(address)) {
			return new CircularSlot(command, address);
		} else {
			ExprParser ex = new ExprParser();
			Expr expr = null;
			try {
				expr = ex.build(command);
			} catch (IOException e) {
			}
			return new ExprSlot(expr, address);
		}
	}
}
