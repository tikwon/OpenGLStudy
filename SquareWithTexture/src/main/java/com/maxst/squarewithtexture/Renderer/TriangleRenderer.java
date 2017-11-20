package com.maxst.squarewithtexture.Renderer;


import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.maxst.squarewithtexture.Figure.Triangle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TriangleRenderer implements GLSurfaceView.Renderer {

	public Triangle triangle;

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//		triangle = new Triangle(this);
		triangle = new Triangle();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
		triangle.draw();
	}

//	public static int loadShader(int type, String shaderCode) {
//		int shader = GLES20.glCreateShader(type);
//		GLES20.glShaderSource(shader, shaderCode);
//		GLES20.glCompileShader(shader);
//		return shader;
//	}
}
