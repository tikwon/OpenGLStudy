package com.maxst.squarewithtexture.Renderer;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.maxst.squarewithtexture.Figure.Square;
import com.maxst.squarewithtexture.Figure.TexturedSquare;

import java.util.ConcurrentModificationException;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TexturedSquareRenderer implements GLSurfaceView.Renderer {

	private static String TAG;

	public TexturedSquare texturedSquare;
	private Context context;

	public TexturedSquareRenderer(Context context){
		this.context = context;

		TAG = this.getClass().getSimpleName();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		Bitmap image = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("drawable/maxst_logo",null,context.getPackageName()));
		texturedSquare = new TexturedSquare(image);

//		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//		GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);

		Log.i(TAG, "onSurfaceCreated");
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GLES20.glViewport(0, 0, width, height);

//		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
//		GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);

		Log.i(TAG, "onSurfaceChanged");

	}

	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		GLES20.glClearColor(1.0f, 1.0f, 0.0f, 1.0f);
		texturedSquare.draw();

		Log.i(TAG, "onDrawFrame");
	}
}
