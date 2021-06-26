package com.umarsani.pab.tubes.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class InferenceFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private InferenceFragmentArgs() {
  }

  private InferenceFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static InferenceFragmentArgs fromBundle(@NonNull Bundle bundle) {
    InferenceFragmentArgs __result = new InferenceFragmentArgs();
    bundle.setClassLoader(InferenceFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("root_dir")) {
      String rootDir;
      rootDir = bundle.getString("root_dir");
      if (rootDir == null) {
        throw new IllegalArgumentException("Argument \"root_dir\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("root_dir", rootDir);
    } else {
      throw new IllegalArgumentException("Required argument \"root_dir\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getRootDir() {
    return (String) arguments.get("root_dir");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("root_dir")) {
      String rootDir = (String) arguments.get("root_dir");
      __result.putString("root_dir", rootDir);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    InferenceFragmentArgs that = (InferenceFragmentArgs) object;
    if (arguments.containsKey("root_dir") != that.arguments.containsKey("root_dir")) {
      return false;
    }
    if (getRootDir() != null ? !getRootDir().equals(that.getRootDir()) : that.getRootDir() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getRootDir() != null ? getRootDir().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "InferenceFragmentArgs{"
        + "rootDir=" + getRootDir()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(InferenceFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String rootDir) {
      if (rootDir == null) {
        throw new IllegalArgumentException("Argument \"root_dir\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("root_dir", rootDir);
    }

    @NonNull
    public InferenceFragmentArgs build() {
      InferenceFragmentArgs result = new InferenceFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setRootDir(@NonNull String rootDir) {
      if (rootDir == null) {
        throw new IllegalArgumentException("Argument \"root_dir\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("root_dir", rootDir);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getRootDir() {
      return (String) arguments.get("root_dir");
    }
  }
}
