package com.applovin.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinCmpError {

    public enum Code {
        UNSPECIFIED(-1),
        INTEGRATION_ERROR(1),
        FORM_UNAVAILABLE(2),
        FORM_NOT_REQUIRED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8037a;

        Code(int i10) {
            this.f8037a = i10;
        }

        public int getValue() {
            return this.f8037a;
        }
    }

    int getCmpCode();

    String getCmpMessage();

    Code getCode();

    String getMessage();
}
