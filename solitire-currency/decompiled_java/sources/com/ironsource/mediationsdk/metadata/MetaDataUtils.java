package com.ironsource.mediationsdk.metadata;

import android.text.TextUtils;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.metadata.MetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class MetaDataUtils {
    public static String checkMetaDataKeyValidity(String str) {
        return (str == null || str.length() > 2048) ? "The MetaData key you entered is invalid. Please enter a key of maximum 2048 characters." : "";
    }

    public static String checkMetaDataValueValidity(List<String> list) {
        if (list.isEmpty()) {
            return "The MetaData list should include at least one element.";
        }
        for (String str : list) {
            if (str == null || str.length() > 2048) {
                return "The MetaData value(s) you entered is invalid. Please enter a value of maximum 2048 characters.";
            }
        }
        return "";
    }

    public static MetaData formatMetaData(String str, List<String> list) {
        if (!isKnownKey(str)) {
            return new MetaData(str, list);
        }
        String lowerCase = StringUtils.toLowerCase(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : list) {
            MetaData.MetaDataValueTypes valueTypeForKey = getValueTypeForKey(lowerCase);
            String valueForType = formatValueForType(str2, valueTypeForKey);
            arrayList.add(valueTypeForKey);
            arrayList2.add(valueForType);
        }
        return new MetaData(lowerCase, arrayList2, arrayList);
    }

    public static String formatValueForType(String str, MetaData.MetaDataValueTypes metaDataValueTypes) {
        if (metaDataValueTypes != MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN) {
            return str;
        }
        String str2 = a.f13688g;
        if (!str.equalsIgnoreCase(a.f13688g) && !str.equalsIgnoreCase("yes")) {
            str2 = "false";
            if (!str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no")) {
                return "";
            }
        }
        return str2;
    }

    public static boolean getMetaDataBooleanValue(String str) {
        return !str.equals("false");
    }

    public static MetaData.MetaDataValueTypes getValueTypeForKey(String str) {
        return (str.equalsIgnoreCase(a.f13682a) || str.equalsIgnoreCase(a.f13683b) || str.equalsIgnoreCase(a.f13684c) || str.equalsIgnoreCase(a.f13685d)) ? MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN : MetaData.MetaDataValueTypes.META_DATA_VALUE_STRING;
    }

    public static boolean isKnownKey(String str) {
        return a.f13694m.contains(str.toLowerCase(Locale.getDefault()));
    }

    public static boolean isMediationKeysBeforeInit(String str) {
        return a.f13693l.contains(str.toLowerCase(Locale.getDefault()));
    }

    public static boolean isMediationOnlyKey(String str) {
        return a.f13692k.contains(str.toLowerCase(Locale.getDefault()));
    }

    public static boolean isValidCCPAMetaData(String str, String str2) {
        return isValidMetaData(str, a.f13682a, str2);
    }

    public static boolean isValidMetaData(String str, String str2, String str3) {
        return str.equalsIgnoreCase(str2) && !TextUtils.isEmpty(str3);
    }
}
