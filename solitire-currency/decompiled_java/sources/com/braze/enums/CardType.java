package com.braze.enums;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public enum CardType {
    IMAGE,
    CAPTIONED_IMAGE,
    DEFAULT,
    SHORT_NEWS,
    TEXT_ANNOUNCEMENT,
    CONTROL;

    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final CardType fromValue(int i10) {
            return CardType.values()[i10];
        }

        private Companion() {
        }
    }

    public final int getValue() {
        return ordinal();
    }
}
