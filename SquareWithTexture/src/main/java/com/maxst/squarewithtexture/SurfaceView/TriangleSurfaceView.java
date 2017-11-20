package com.maxst.squarewithtexture.SurfaceView;


import android.content.Context;
import android.opengl.GLSurfaceView;

import com.maxst.squarewithtexture.Renderer.TriangleRenderer;

public class TriangleSurfaceView extends GLSurfaceView {

	public final TriangleRenderer triangleRenderer;

	public TriangleSurfaceView(Context context) {
		super(context);

		setEGLContextClientVersion(2);

		triangleRenderer = new TriangleRenderer();

		setRenderer(triangleRenderer);

		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		//setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
}
