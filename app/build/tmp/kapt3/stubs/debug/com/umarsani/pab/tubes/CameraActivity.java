package com.umarsani.pab.tubes;

import java.lang.System;

/**
 * Author: Margaret Maynard-Reid
 *
 * This is an Android sample app that showcases the following:
 *
 * 1. Jetpack navigation component - navigate between Fragments
 * 2. CameraX - permission check, camera setup, and image capture use case
 * 3. ML Model binding - easy import of .tflite model in Android Studio
 * 4. Transform a selfie image to an anime image with selfie2anime.tflite model
 *
 * This MainActivity.kt is the main entry point into the sample app.
 * There is one single Activity with 3 Fragments:
 *
 * 1. PermissionsFragment.kt - check camera permission
 * 2. CameraFragment.kt - capture photo
 * 3. InferenceFragment.kt - display the selfie & anime images
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/umarsani/pab/tubes/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "container", "Landroid/widget/FrameLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.FrameLayout container;
    public static final com.umarsani.pab.tubes.CameraActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public CameraActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/umarsani/pab/tubes/CameraActivity$Companion;", "", "()V", "getOutputDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        /**
         * Use external media if it is available, our app's file directory otherwise
         */
        @org.jetbrains.annotations.NotNull()
        public final java.io.File getOutputDirectory(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}