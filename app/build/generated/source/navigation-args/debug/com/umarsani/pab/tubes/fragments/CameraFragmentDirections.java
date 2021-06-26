package com.umarsani.pab.tubes.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.umarsani.pab.tubes.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CameraFragmentDirections {
  private CameraFragmentDirections() {
  }

  @NonNull
  public static ActionCameraToInference actionCameraToInference(@NonNull String rootDir) {
    return new ActionCameraToInference(rootDir);
  }

  @NonNull
  public static NavDirections actionCameraToPermissions() {
    return new ActionOnlyNavDirections(R.id.action_camera_to_permissions);
  }

  public static class ActionCameraToInference implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCameraToInference(@NonNull String rootDir) {
      if (rootDir == null) {
        throw new IllegalArgumentException("Argument \"root_dir\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("root_dir", rootDir);
    }

    @NonNull
    public ActionCameraToInference setRootDir(@NonNull String rootDir) {
      if (rootDir == null) {
        throw new IllegalArgumentException("Argument \"root_dir\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("root_dir", rootDir);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("root_dir")) {
        String rootDir = (String) arguments.get("root_dir");
        __result.putString("root_dir", rootDir);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_camera_to_inference;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getRootDir() {
      return (String) arguments.get("root_dir");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCameraToInference that = (ActionCameraToInference) object;
      if (arguments.containsKey("root_dir") != that.arguments.containsKey("root_dir")) {
        return false;
      }
      if (getRootDir() != null ? !getRootDir().equals(that.getRootDir()) : that.getRootDir() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getRootDir() != null ? getRootDir().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCameraToInference(actionId=" + getActionId() + "){"
          + "rootDir=" + getRootDir()
          + "}";
    }
  }
}
