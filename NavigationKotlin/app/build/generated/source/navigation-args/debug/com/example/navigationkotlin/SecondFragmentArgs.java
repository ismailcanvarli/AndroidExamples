package com.example.navigationkotlin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SecondFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SecondFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private SecondFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SecondFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SecondFragmentArgs __result = new SecondFragmentArgs();
    bundle.setClassLoader(SecondFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("username")) {
      String username;
      username = bundle.getString("username");
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("username", username);
    } else {
      __result.arguments.put("username", "\"username\"");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SecondFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    SecondFragmentArgs __result = new SecondFragmentArgs();
    if (savedStateHandle.contains("username")) {
      String username;
      username = savedStateHandle.get("username");
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("username", username);
    } else {
      __result.arguments.put("username", "\"username\"");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUsername() {
    return (String) arguments.get("username");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("username")) {
      String username = (String) arguments.get("username");
      __result.putString("username", username);
    } else {
      __result.putString("username", "\"username\"");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("username")) {
      String username = (String) arguments.get("username");
      __result.set("username", username);
    } else {
      __result.set("username", "\"username\"");
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
    SecondFragmentArgs that = (SecondFragmentArgs) object;
    if (arguments.containsKey("username") != that.arguments.containsKey("username")) {
      return false;
    }
    if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SecondFragmentArgs{"
        + "username=" + getUsername()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull SecondFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public SecondFragmentArgs build() {
      SecondFragmentArgs result = new SecondFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUsername(@NonNull String username) {
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("username", username);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getUsername() {
      return (String) arguments.get("username");
    }
  }
}
