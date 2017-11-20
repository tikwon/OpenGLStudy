package com.maxst.squarewithtexture.SurfaceView;


import android.content.Context;
import android.opengl.GLSurfaceView;

import com.maxst.squarewithtexture.Renderer.SquareRenderer;
import com.maxst.squarewithtexture.Renderer.TexturedSquareRenderer;

public class TexturedSquareSurfaceView extends GLSurfaceView {

	public final TexturedSquareRenderer texturedSquareRenderer;

	public TexturedSquareSurfaceView(Context context) {
		super(context);

		setEGLContextClientVersion(2);

		texturedSquareRenderer = new TexturedSquareRenderer(context);

		setRenderer(texturedSquareRenderer);

		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
}
