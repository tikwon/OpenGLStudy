package com.maxst.squarewithtexture.SurfaceView;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

import com.maxst.squarewithtexture.Renderer.CameraPreviewRenderer;

public class CameraPreview extends GLSurfaceView {

	CameraPreviewRenderer cameraRenderer;

	public CameraPreview(Context context) {
		super(context);
		cameraRenderer = new CameraPreviewRenderer(this);
		setEGLContextClientVersion(2);
		setRenderer(cameraRenderer);
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		super.surfaceCreated(holder);
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		cameraRenderer.close();
		super.surfaceDestroyed(holder);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		super.surfaceChanged(holder, format, w, h);
	}
}
