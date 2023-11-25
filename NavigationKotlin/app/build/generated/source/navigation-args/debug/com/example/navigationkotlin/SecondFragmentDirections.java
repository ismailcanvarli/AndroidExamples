package com.example.navigationkotlin;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class SecondFragmentDirections {
  private SecondFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSecondFragmentToFirstFragment2() {
    return new ActionOnlyNavDirections(R.id.action_secondFragment_to_firstFragment2);
  }
}
