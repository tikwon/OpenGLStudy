package com.maxst.squarewithtexture;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.maxst.squarewithtexture.SurfaceView.SquareSurfaceView;
import com.maxst.squarewithtexture.SurfaceView.TexturedSquareSurfaceView;

public class MainActivity extends Activity {

	private GLSurfaceView mGLView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity
//		mGLView = new MyGLSurfaceView(this);
//		mGLView = new TriangleSurfaceView(this);
//		mGLView = new SquareSurfaceView(this);
		mGLView = new TexturedSquareSurfaceView(this);
		setContentView(mGLView);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// The following call pauses the rendering thread.
		// If your OpenGL application is memory intensive,
		// you should consider de-allocating objects that
		// consume significant memory here.
		mGLView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The following call resumes a paused rendering thread.
		// If you de-allocated graphic objects for onPause()
		// this is a good place to re-allocate them.
		mGLView.onResume();
	}
}
