package com.epic.bobrunningpuzzle.model;

import com.epic.bobrunningpuzzle.view.RendererVisitor;

public class Goal extends Surmountable {

	@Override
	public void update(float delta) {
		// none
	}

	@Override
	public void updateBob(float delta, Bob bob) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptRendererVisitor(RendererVisitor rendererVisitor) {
		rendererVisitor.draw(this);
	}

}
