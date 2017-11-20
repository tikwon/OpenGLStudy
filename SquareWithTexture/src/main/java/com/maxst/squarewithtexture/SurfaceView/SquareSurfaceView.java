package com.maxst.squarewithtexture.SurfaceView;


import android.content.Context;
import android.opengl.GLSurfaceView;

import com.maxst.squarewithtexture.Renderer.SquareRenderer;

public class SquareSurfaceView extends GLSurfaceView {

	public final SquareRenderer squareRenderer;

	public SquareSurfaceView(Context context) {
		super(context);

		setEGLContextClientVersion(2);

		squareRenderer = new SquareRenderer();

		setRenderer(squareRenderer);

		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
}
