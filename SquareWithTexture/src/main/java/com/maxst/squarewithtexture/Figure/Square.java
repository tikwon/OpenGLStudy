package com.maxst.squarewithtexture.Figure;


import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Square {

	private FloatBuffer mVertexBuffer;
	private ShortBuffer mDrawListBuffer;

	private final String mVertexShaderCode =
			"attribute vec4 vPosition;\n" +
					"void main(){\n" +
					"gl_Position = vPosition;\n" +
					"}\n";

	private final String mFragmentShaderCode =
			"precision mediump float;\n" +
					"uniform vec4 vColor;\n" +
					"void main(){\n" +
					"gl_FragColor = vColor;\n" +
					"}\n";

	static final int COORDS_PER_VERTEX = 3;

	float mSquareCoords[] = {
			-0.5f, 0.5f, 0.0f,
			-0.5f, -0.5f, 0.0f,
			0.5f, -0.5f, 0.0f,
			0.5f, 0.5f, 0.0f
	};

	float mColor[] = {1.0f, 1.0f, 0.0f, 1.0f};
	private short mDrawOrder[] = {0, 1, 2, 0, 2, 3};
	private final int mProgram;
	private int mPositionHandle;
	private int mColorHandle;
	private final int mVertexCount = mSquareCoords.length / COORDS_PER_VERTEX;
	private final int mVertexStride = COORDS_PER_VERTEX * 4;

	public Square() {

		ByteBuffer bb = ByteBuffer.allocateDirect(mSquareCoords.length * 4);
		bb.order(ByteOrder.nativeOrder());
		mVertexBuffer = bb.asFloatBuffer();
		mVertexBuffer.put(mSquareCoords);
		mVertexBuffer.position(0);

		ByteBuffer dlb = ByteBuffer.allocateDirect(mDrawOrder.length * 2);
		dlb.order(ByteOrder.nativeOrder());
		mDrawListBuffer = dlb.asShortBuffer();
		mDrawListBuffer.put(mDrawOrder);
		mDrawListBuffer.position(0);

		int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, mVertexShaderCode);
		int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, mFragmentShaderCode);

		mProgram = GLES20.glCreateProgram();
		GLES20.glAttachShader(mProgram, vertexShader);
		GLES20.glAttachShader(mProgram, fragmentShader);
		GLES20.glLinkProgram(mProgram);
	}

	public void draw() {

		GLES20.glUseProgram(mProgram);
		mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");
		GLES20.glEnableVertexAttribArray(mPositionHandle);
		GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, mVertexStride, mVertexBuffer);
		mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
		GLES20.glUniform4fv(mColorHandle, 1, mColor, 0);
		GLES20.glDrawElements(GLES20.GL_TRIANGLES, mDrawOrder.length, GLES20.GL_UNSIGNED_SHORT, mDrawListBuffer);
		GLES20.glDisableVertexAttribArray(mPositionHandle);

	}

	public static int loadShader(int type, String shaderCode) {
		int shader = GLES20.glCreateShader(type);
		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);
		return shader;
	}
}
