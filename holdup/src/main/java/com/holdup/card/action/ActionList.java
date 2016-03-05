package com.holdup.card.action;

import java.util.ArrayList;

public class ActionList extends ArrayList<Action> implements Action {

	private static final long serialVersionUID = 6703610378383646961L;
	
	public static ActionList create(Action... actions) {
		ActionList actionList = new ActionList();
		for (Action a : actions) {
			actionList.add(a);
		}
		return actionList;
	}
	
	public void doIt() {
		for (Action a : this) {
			a.doIt();
		}
	}
	
	public void undo() {
		for (int i=this.size()-1;i>=0;i--) {
			this.get(i).undo();
		}
	}
}
