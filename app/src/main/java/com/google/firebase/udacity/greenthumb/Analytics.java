package com.google.firebase.udacity.greenthumb;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.udacity.greenthumb.data.Plant;
/**
 * {@link Analytics} helps log analytics events
 */
public class Analytics {
    public static void logEventAddToCart(Context context, Plant plant, long quantity) {
        Bundle params = new Bundle();
        params.putInt(FirebaseAnalytics.Param.ITEM_ID, plant.id);
        params.putString(FirebaseAnalytics.Param.ITEM_NAME, plant.name);
        params.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "plants");
        params.putDouble(FirebaseAnalytics.Param.QUANTITY, quantity);
        params.putDouble(FirebaseAnalytics.Param.PRICE, plant.price);
        FirebaseAnalytics.getInstance(context).logEvent(
                FirebaseAnalytics.Event.ADD_TO_CART, params);
    }
    public static void setUserPropertyGardeningExperience(Context context, int experienceIndex) {
        String userPropertyKey = context.getString(
                R.string.user_property_key_gardening_experience);
        String[] userPropertyValues = context.getResources()
                .getStringArray(R.array.user_property_values_gardening_experience);
        FirebaseAnalytics.getInstance(context).setUserProperty(
                userPropertyKey, userPropertyValues[experienceIndex]);
    }
}