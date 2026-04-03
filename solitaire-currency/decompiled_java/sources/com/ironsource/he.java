package com.ironsource;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public interface he {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<kb> f12473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Exception f12476d;

        public a(ArrayList<kb> arrayList) {
            this.f12474b = false;
            this.f12475c = -1;
            this.f12473a = arrayList;
        }

        public a a(int i10) {
            return new a(this.f12473a, i10, this.f12474b, this.f12476d);
        }

        public ArrayList<kb> b() {
            return this.f12473a;
        }

        public boolean c() {
            return this.f12474b;
        }

        public String toString() {
            return "EventSendResult{success=" + this.f12474b + ", responseCode=" + this.f12475c + ", exception=" + this.f12476d + '}';
        }

        a(ArrayList<kb> arrayList, int i10, boolean z10, Exception exc) {
            this.f12473a = arrayList;
            this.f12474b = z10;
            this.f12476d = exc;
            this.f12475c = i10;
        }

        public a a(Exception exc) {
            return new a(this.f12473a, this.f12475c, this.f12474b, exc);
        }

        public a a(boolean z10) {
            return new a(this.f12473a, this.f12475c, z10, this.f12476d);
        }

        public String a() {
            if (this.f12474b) {
                return "";
            }
            return "rc=" + this.f12475c + ", ex=" + this.f12476d;
        }
    }

    void a(a aVar);
}
