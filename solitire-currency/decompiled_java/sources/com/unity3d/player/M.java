package com.unity3d.player;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.reflect.Member;

/* JADX INFO: loaded from: classes4.dex */
final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f23961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Member f23965e;

    M(Class cls, String str, String str2) {
        this.f23961a = cls;
        this.f23962b = str;
        this.f23963c = str2;
        this.f23964d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m10 = (M) obj;
        return this.f23964d == m10.f23964d && this.f23963c.equals(m10.f23963c) && this.f23962b.equals(m10.f23962b) && this.f23961a.equals(m10.f23961a);
    }

    public final int hashCode() {
        return this.f23964d;
    }
}
