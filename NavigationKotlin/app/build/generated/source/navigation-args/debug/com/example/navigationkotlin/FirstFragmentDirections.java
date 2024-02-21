package com.example.navigationkotlin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class FirstFragmentDirections {
  private FirstFragmentDirections() {
  }

  @NonNull
  public static ActionFirstFragmentToSecondFragment actionFirstFragmentToSecondFragment() {
    return new ActionFirstFragmentToSecondFragment();
  }

  public static class ActionFirstFragmentToSecondFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFirstFragmentToSecondFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFirstFragmentToSecondFragment setUsername(@NonNull String username) {
      if (username == null) {
        throw new IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("username", username);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("username")) {
        String username = (String) arguments.get("username");
        __result.putString("username", username);
      } else {
        __result.putString("username", "\"username\"");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_firstFragment_to_secondFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUsername() {
      return (String) arguments.get("username");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionFirstFragmentToSecondFragment that = (ActionFirstFragmentToSecondFragment) object;
      if (arguments.containsKey("username") != that.arguments.containsKey("username")) {
        return false;
      }
      if (getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null) {
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
      result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionFirstFragmentToSecondFragment(actionId=" + getActionId() + "){"
          + "username=" + getUsername()
          + "}";
    }
  }
}
