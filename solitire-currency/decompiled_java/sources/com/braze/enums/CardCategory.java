package com.braze.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum CardCategory {
    ADVERTISING,
    ANNOUNCEMENTS,
    NEWS,
    SOCIAL,
    NO_CATEGORY;

    private static final Map<String, CardCategory> CARD_CATEGORY_HASH_MAP = new HashMap();

    static {
        for (CardCategory cardCategory : EnumSet.allOf(CardCategory.class)) {
            CARD_CATEGORY_HASH_MAP.put(cardCategory.toString(), cardCategory);
        }
    }

    public static CardCategory get(String str) {
        return CARD_CATEGORY_HASH_MAP.get(str.toUpperCase(Locale.US));
    }

    public static EnumSet<CardCategory> getAllCategories() {
        return EnumSet.allOf(CardCategory.class);
    }
}
