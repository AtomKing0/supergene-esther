package com.applovin.impl;

import androidx.media3.common.C;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.i4;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.ironsource.sm;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import io.sentry.protocol.Geo;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l4 implements Comparable {
    public static final l4 A;
    public static final l4 A0;
    public static final l4 A1;
    public static final l4 A2;
    public static final l4 A3;
    public static final l4 A4;
    public static final l4 A5;
    public static final l4 B;
    public static final l4 B0;
    public static final l4 B1;
    public static final l4 B2;
    public static final l4 B3;
    public static final l4 B4;
    public static final l4 B5;
    public static final l4 C;
    public static final l4 C0;
    public static final l4 C1;
    public static final l4 C2;
    public static final l4 C3;
    public static final l4 C4;
    public static final l4 C5;
    public static final l4 D;
    public static final l4 D0;
    public static final l4 D1;
    public static final l4 D2;
    public static final l4 D3;
    public static final l4 D4;
    public static final l4 D5;
    public static final l4 E;
    public static final l4 E0;
    public static final l4 E1;
    public static final l4 E2;
    public static final l4 E3;
    public static final l4 E4;
    public static final l4 E5;
    public static final l4 F;
    public static final l4 F0;
    public static final l4 F1;
    public static final l4 F2;
    public static final l4 F3;
    public static final l4 F4;
    public static final l4 F5;
    public static final l4 G;
    public static final l4 G0;
    public static final l4 G1;
    public static final l4 G2;
    public static final l4 G3;
    public static final l4 G4;
    public static final l4 G5;
    public static final l4 H;
    public static final l4 H0;
    public static final l4 H1;
    public static final l4 H2;
    public static final l4 H3;
    public static final l4 H4;
    public static final l4 H5;
    public static final l4 I;
    public static final l4 I0;
    public static final l4 I1;
    public static final l4 I2;
    public static final l4 I3;
    public static final l4 I4;
    public static final l4 I5;
    public static final l4 J;
    public static final l4 J0;
    public static final l4 J1;
    public static final l4 J2;
    public static final l4 J3;
    public static final l4 J4;
    public static final l4 J5;
    public static final l4 K;
    public static final l4 K0;
    public static final l4 K1;
    public static final l4 K2;
    public static final l4 K3;
    public static final l4 K4;
    public static final l4 K5;
    public static final l4 L;
    public static final l4 L0;
    public static final l4 L1;
    public static final l4 L2;
    public static final l4 L3;
    public static final l4 L4;
    public static final l4 L5;
    public static final l4 M;
    public static final l4 M0;
    public static final l4 M1;
    public static final l4 M2;
    public static final l4 M3;
    public static final l4 M4;
    public static final l4 M5;
    public static final l4 N;
    public static final l4 N0;
    public static final l4 N1;
    public static final l4 N2;
    public static final l4 N3;
    public static final l4 N4;
    public static final l4 N5;
    public static final l4 O;
    public static final l4 O0;
    public static final l4 O1;
    public static final l4 O2;
    public static final l4 O3;
    public static final l4 O4;
    public static final l4 O5;
    public static final l4 P;
    public static final l4 P0;
    public static final l4 P1;
    public static final l4 P2;
    public static final l4 P3;
    public static final l4 P4;
    public static final l4 P5;
    public static final l4 Q;
    public static final l4 Q0;
    public static final l4 Q1;
    public static final l4 Q2;
    public static final l4 Q3;
    public static final l4 Q4;
    public static final l4 Q5;
    public static final l4 R;
    public static final l4 R0;
    public static final l4 R1;
    public static final l4 R2;
    public static final l4 R3;
    public static final l4 R4;
    public static final l4 R5;
    public static final l4 S;
    public static final l4 S0;
    public static final l4 S1;
    public static final l4 S2;
    public static final l4 S3;
    public static final l4 S4;
    public static final l4 S5;
    public static final l4 T;
    public static final l4 T0;
    public static final l4 T1;
    public static final l4 T2;
    public static final l4 T3;
    public static final l4 T4;
    public static final l4 T5;
    public static final l4 U;
    public static final l4 U0;
    public static final l4 U1;
    public static final l4 U2;
    public static final l4 U3;
    public static final l4 U4;
    public static final l4 U5;
    public static final l4 V;
    public static final l4 V0;
    public static final l4 V1;
    public static final l4 V2;
    public static final l4 V3;
    public static final l4 V4;
    public static final l4 V5;
    public static final l4 W;
    public static final l4 W0;
    public static final l4 W1;
    public static final l4 W2;
    public static final l4 W3;
    public static final l4 W4;
    public static final l4 W5;
    public static final l4 X;
    public static final l4 X0;
    public static final l4 X1;
    public static final l4 X2;
    public static final l4 X3;
    public static final l4 X4;
    public static final l4 X5;
    public static final l4 Y;
    public static final l4 Y0;
    public static final l4 Y1;
    public static final l4 Y2;
    public static final l4 Y3;
    public static final l4 Y4;
    public static final l4 Y5;
    public static final l4 Z;
    public static final l4 Z0;
    public static final l4 Z1;
    public static final l4 Z2;
    public static final l4 Z3;
    public static final l4 Z4;
    public static final l4 Z5;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final l4 f5592a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final l4 f5593a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public static final l4 f5594a2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public static final l4 f5595a3;

    /* JADX INFO: renamed from: a4, reason: collision with root package name */
    public static final l4 f5596a4;

    /* JADX INFO: renamed from: a5, reason: collision with root package name */
    public static final l4 f5597a5;

    /* JADX INFO: renamed from: a6, reason: collision with root package name */
    public static final l4 f5598a6;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final l4 f5599b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final l4 f5600b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public static final l4 f5601b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final l4 f5602b3;

    /* JADX INFO: renamed from: b4, reason: collision with root package name */
    public static final l4 f5603b4;

    /* JADX INFO: renamed from: b5, reason: collision with root package name */
    public static final l4 f5604b5;

    /* JADX INFO: renamed from: b6, reason: collision with root package name */
    public static final l4 f5605b6;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final l4 f5607c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final l4 f5608c1;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final l4 f5609c2;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final l4 f5610c3;

    /* JADX INFO: renamed from: c4, reason: collision with root package name */
    public static final l4 f5611c4;

    /* JADX INFO: renamed from: c5, reason: collision with root package name */
    public static final l4 f5612c5;

    /* JADX INFO: renamed from: c6, reason: collision with root package name */
    public static final l4 f5613c6;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final l4 f5615d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final l4 f5616d1;

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final l4 f5617d2;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final l4 f5618d3;

    /* JADX INFO: renamed from: d4, reason: collision with root package name */
    public static final l4 f5619d4;

    /* JADX INFO: renamed from: d5, reason: collision with root package name */
    public static final l4 f5620d5;

    /* JADX INFO: renamed from: d6, reason: collision with root package name */
    public static final l4 f5621d6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l4 f5622e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final l4 f5623e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final l4 f5624e1;

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final l4 f5625e2;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final l4 f5626e3;

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    public static final l4 f5627e4;

    /* JADX INFO: renamed from: e5, reason: collision with root package name */
    public static final l4 f5628e5;

    /* JADX INFO: renamed from: e6, reason: collision with root package name */
    public static final l4 f5629e6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l4 f5630f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final l4 f5631f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final l4 f5632f1;

    /* JADX INFO: renamed from: f2, reason: collision with root package name */
    public static final l4 f5633f2;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final l4 f5634f3;

    /* JADX INFO: renamed from: f4, reason: collision with root package name */
    public static final l4 f5635f4;

    /* JADX INFO: renamed from: f5, reason: collision with root package name */
    public static final l4 f5636f5;

    /* JADX INFO: renamed from: f6, reason: collision with root package name */
    public static final l4 f5637f6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l4 f5638g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final l4 f5639g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final l4 f5640g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final l4 f5641g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final l4 f5642g3;

    /* JADX INFO: renamed from: g4, reason: collision with root package name */
    public static final l4 f5643g4;

    /* JADX INFO: renamed from: g5, reason: collision with root package name */
    public static final l4 f5644g5;

    /* JADX INFO: renamed from: g6, reason: collision with root package name */
    public static final l4 f5645g6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l4 f5646h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final l4 f5647h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final l4 f5648h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final l4 f5649h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final l4 f5650h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public static final l4 f5651h4;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    public static final l4 f5652h5;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    public static final l4 f5653h6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l4 f5654i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final l4 f5655i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final l4 f5656i1;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final l4 f5657i2;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final l4 f5658i3;

    /* JADX INFO: renamed from: i4, reason: collision with root package name */
    public static final l4 f5659i4;

    /* JADX INFO: renamed from: i5, reason: collision with root package name */
    public static final l4 f5660i5;

    /* JADX INFO: renamed from: i6, reason: collision with root package name */
    public static final l4 f5661i6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l4 f5662j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final l4 f5663j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final l4 f5664j1;

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final l4 f5665j2;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final l4 f5666j3;

    /* JADX INFO: renamed from: j4, reason: collision with root package name */
    public static final l4 f5667j4;

    /* JADX INFO: renamed from: j5, reason: collision with root package name */
    public static final l4 f5668j5;

    /* JADX INFO: renamed from: j6, reason: collision with root package name */
    public static final l4 f5669j6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l4 f5670k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final l4 f5671k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final l4 f5672k1;

    /* JADX INFO: renamed from: k2, reason: collision with root package name */
    public static final l4 f5673k2;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final l4 f5674k3;

    /* JADX INFO: renamed from: k4, reason: collision with root package name */
    public static final l4 f5675k4;

    /* JADX INFO: renamed from: k5, reason: collision with root package name */
    public static final l4 f5676k5;

    /* JADX INFO: renamed from: k6, reason: collision with root package name */
    public static final l4 f5677k6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l4 f5678l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final l4 f5679l0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final l4 f5680l1;

    /* JADX INFO: renamed from: l2, reason: collision with root package name */
    public static final l4 f5681l2;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final l4 f5682l3;

    /* JADX INFO: renamed from: l4, reason: collision with root package name */
    public static final l4 f5683l4;

    /* JADX INFO: renamed from: l5, reason: collision with root package name */
    public static final l4 f5684l5;

    /* JADX INFO: renamed from: l6, reason: collision with root package name */
    public static final l4 f5685l6;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l4 f5686m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final l4 f5687m0;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final l4 f5688m1;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    public static final l4 f5689m2;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final l4 f5690m3;

    /* JADX INFO: renamed from: m4, reason: collision with root package name */
    public static final l4 f5691m4;

    /* JADX INFO: renamed from: m5, reason: collision with root package name */
    public static final l4 f5692m5;

    /* JADX INFO: renamed from: m6, reason: collision with root package name */
    public static final l4 f5693m6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l4 f5694n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final l4 f5695n0;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final l4 f5696n1;

    /* JADX INFO: renamed from: n2, reason: collision with root package name */
    public static final l4 f5697n2;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public static final l4 f5698n3;

    /* JADX INFO: renamed from: n4, reason: collision with root package name */
    public static final l4 f5699n4;

    /* JADX INFO: renamed from: n5, reason: collision with root package name */
    public static final l4 f5700n5;

    /* JADX INFO: renamed from: n6, reason: collision with root package name */
    public static final l4 f5701n6;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l4 f5702o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final l4 f5703o0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final l4 f5704o1;

    /* JADX INFO: renamed from: o2, reason: collision with root package name */
    public static final l4 f5705o2;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public static final l4 f5706o3;

    /* JADX INFO: renamed from: o4, reason: collision with root package name */
    public static final l4 f5707o4;

    /* JADX INFO: renamed from: o5, reason: collision with root package name */
    public static final l4 f5708o5;

    /* JADX INFO: renamed from: o6, reason: collision with root package name */
    public static final l4 f5709o6;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final l4 f5710p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final l4 f5711p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final l4 f5712p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final l4 f5713p2;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final l4 f5714p3;

    /* JADX INFO: renamed from: p4, reason: collision with root package name */
    public static final l4 f5715p4;

    /* JADX INFO: renamed from: p5, reason: collision with root package name */
    public static final l4 f5716p5;

    /* JADX INFO: renamed from: p6, reason: collision with root package name */
    public static final l4 f5717p6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l4 f5718q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final l4 f5719q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final l4 f5720q1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    public static final l4 f5721q2;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public static final l4 f5722q3;

    /* JADX INFO: renamed from: q4, reason: collision with root package name */
    public static final l4 f5723q4;

    /* JADX INFO: renamed from: q5, reason: collision with root package name */
    public static final l4 f5724q5;

    /* JADX INFO: renamed from: q6, reason: collision with root package name */
    public static final l4 f5725q6;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l4 f5726r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final l4 f5727r0;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final l4 f5728r1;

    /* JADX INFO: renamed from: r2, reason: collision with root package name */
    public static final l4 f5729r2;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public static final l4 f5730r3;

    /* JADX INFO: renamed from: r4, reason: collision with root package name */
    public static final l4 f5731r4;

    /* JADX INFO: renamed from: r5, reason: collision with root package name */
    public static final l4 f5732r5;

    /* JADX INFO: renamed from: r6, reason: collision with root package name */
    public static final l4 f5733r6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l4 f5734s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final l4 f5735s0;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final l4 f5736s1;

    /* JADX INFO: renamed from: s2, reason: collision with root package name */
    public static final l4 f5737s2;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public static final l4 f5738s3;

    /* JADX INFO: renamed from: s4, reason: collision with root package name */
    public static final l4 f5739s4;

    /* JADX INFO: renamed from: s5, reason: collision with root package name */
    public static final l4 f5740s5;

    /* JADX INFO: renamed from: s6, reason: collision with root package name */
    public static final l4 f5741s6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l4 f5742t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final l4 f5743t0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final l4 f5744t1;

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final l4 f5745t2;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public static final l4 f5746t3;

    /* JADX INFO: renamed from: t4, reason: collision with root package name */
    public static final l4 f5747t4;

    /* JADX INFO: renamed from: t5, reason: collision with root package name */
    public static final l4 f5748t5;

    /* JADX INFO: renamed from: t6, reason: collision with root package name */
    public static final l4 f5749t6;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l4 f5750u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final l4 f5751u0;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final l4 f5752u1;

    /* JADX INFO: renamed from: u2, reason: collision with root package name */
    public static final l4 f5753u2;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public static final l4 f5754u3;

    /* JADX INFO: renamed from: u4, reason: collision with root package name */
    public static final l4 f5755u4;

    /* JADX INFO: renamed from: u5, reason: collision with root package name */
    public static final l4 f5756u5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l4 f5757v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final l4 f5758v0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final l4 f5759v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final l4 f5760v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final l4 f5761v3;

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    public static final l4 f5762v4;

    /* JADX INFO: renamed from: v5, reason: collision with root package name */
    public static final l4 f5763v5;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final l4 f5764w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final l4 f5765w0;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final l4 f5766w1;

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    public static final l4 f5767w2;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public static final l4 f5768w3;

    /* JADX INFO: renamed from: w4, reason: collision with root package name */
    public static final l4 f5769w4;

    /* JADX INFO: renamed from: w5, reason: collision with root package name */
    public static final l4 f5770w5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final l4 f5771x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final l4 f5772x0;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final l4 f5773x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final l4 f5774x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public static final l4 f5775x3;

    /* JADX INFO: renamed from: x4, reason: collision with root package name */
    public static final l4 f5776x4;

    /* JADX INFO: renamed from: x5, reason: collision with root package name */
    public static final l4 f5777x5;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final l4 f5778y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final l4 f5779y0;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final l4 f5780y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final l4 f5781y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public static final l4 f5782y3;

    /* JADX INFO: renamed from: y4, reason: collision with root package name */
    public static final l4 f5783y4;

    /* JADX INFO: renamed from: y5, reason: collision with root package name */
    public static final l4 f5784y5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final l4 f5785z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final l4 f5786z0;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final l4 f5787z1;

    /* JADX INFO: renamed from: z2, reason: collision with root package name */
    public static final l4 f5788z2;

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public static final l4 f5789z3;

    /* JADX INFO: renamed from: z4, reason: collision with root package name */
    public static final l4 f5790z4;

    /* JADX INFO: renamed from: z5, reason: collision with root package name */
    public static final l4 f5791z5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f5793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List f5606c = Arrays.asList(Boolean.class, Float.class, Double.class, Integer.class, Long.class, String.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f5614d = new HashMap(512);

    static {
        Boolean bool = Boolean.FALSE;
        f5622e = a("is_disabled", bool);
        f5630f = a("device_id", "");
        Boolean bool2 = Boolean.TRUE;
        f5638g = a("rss", bool2);
        f5646h = a("rssoitf", bool);
        f5654i = a("cpoitf", bool);
        f5662j = a("device_token", "");
        f5670k = a("is_verbose_logging", bool);
        f5678l = a("sc", "");
        f5686m = a("sc2", "");
        f5694n = a("sc3", "");
        f5702o = a("server_installed_at", "");
        f5710p = a("clear_completion_callback_on_failure", bool);
        f5718q = a("sicd_ms", 0L);
        f5726r = a("logcat_max_line_size", 1000);
        f5734s = a("exception_handler_enabled", bool2);
        f5742t = a(com.ironsource.ad.f11264s, "");
        f5750u = a("ps_atu", "");
        f5757v = a("lsu", bool);
        f5764w = a("tla_ms", -1L);
        f5771x = a("uactlac", bool);
        f5778y = a("vsk", bool);
        f5785z = a("error_reporter_v1_sample_percent", 100);
        A = a("health_events_reporter_v1_endpoint", "https://sts.applovin.com/v1/stats/sdk");
        B = a("health_events_reporter_v1_event_level_sampling_percentages", "");
        Float fValueOf = Float.valueOf(-1.0f);
        C = a("health_events_reporter_v1_ad_sampling_percent", fValueOf);
        D = a("health_events_reporter_v1_error_sampling_percent", fValueOf);
        E = a("health_events_reporter_v1_user_session_sampling_percent", fValueOf);
        F = a("health_events_reporter_v1_sampling_percent", Float.valueOf(1.0f));
        G = a("health_events_reporter_v1_batch_grouped_events", bool);
        H = a("health_events_reporter_should_skip_al_events_in_max", bool);
        I = a("health_events_reporter_valid_network_status_codes", "");
        J = a("health_events_reporter_include_cached_asset_info", bool);
        K = a("health_events_reporter_include_html_source", bool);
        L = a("stps", 2);
        M = a("auxiliary_operations_threads", 1);
        N = a("apsobt", bool2);
        O = a("tmtp", 1);
        P = a("network_thread_count", 2);
        Q = a("ntp", 5);
        R = a("ueq", bool);
        S = a("coretc", 1);
        T = a("cachetc", 1);
        U = a("mtc", 1);
        V = a("ttc", 1);
        W = a("otc", 1);
        X = a("uaeq", bool);
        Y = a("ubsm", bool);
        Z = a("ah_cvc", bool2);
        f5592a0 = a("ah_cdde", bool2);
        f5599b0 = a("ah_crut", bool2);
        f5607c0 = a("ah_sae", bool2);
        f5615d0 = a("ah_mvcwges", -1);
        f5623e0 = a("init_omsdk", bool2);
        f5631f0 = a("omsdk_partner_name", "applovin");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f5639g0 = a("ttc_max_click_duration_ms", Long.valueOf(timeUnit.toMillis(1L)));
        f5647h0 = a("ttc_max_click_distance_dp", 10);
        AppLovinTouchToClickListener.ClickRecognitionState clickRecognitionState = AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN;
        f5655i0 = a("ttc_acrsv2a", Integer.valueOf(clickRecognitionState.ordinal()));
        f5663j0 = a("ttc_acrsnv", Integer.valueOf(clickRecognitionState.ordinal()));
        f5671k0 = a("ttc_acrsn", Integer.valueOf(clickRecognitionState.ordinal()));
        f5679l0 = a("ttc_edge_buffer_dp", 0);
        f5687m0 = a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");
        f5695n0 = a("fetch_settings_endpoint", "https://ms.applovin.com/");
        f5703o0 = a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");
        f5711p0 = a("adserver_endpoint", "https://a.applovin.com/");
        f5719q0 = a("adserver_backup_endpoint", "https://a.applvn.com/");
        f5727r0 = a("api_endpoint", "https://d.applovin.com/");
        f5735s0 = a("api_backup_endpoint", "https://d.applvn.com/");
        f5743t0 = a("event_tracking_endpoint_v2", "https://rt.applovin.com/");
        f5751u0 = a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");
        f5758v0 = a("webview_network_error_endpoints_to_report", "applovin.com,applvn.com");
        f5765w0 = a("token_type_prefixes_r", "4!");
        f5772x0 = a("token_type_prefixes_arj", "json_v3!");
        f5779y0 = a("top_level_events", "landing,paused,resumed,cf_start,tos_ok,gdpr_ok,ref,rdf,checkout,iap");
        TimeUnit timeUnit2 = TimeUnit.DAYS;
        f5786z0 = a("cache_file_ttl_seconds", Long.valueOf(timeUnit2.toSeconds(1L)));
        A0 = a("cache_max_size_mb", -1);
        B0 = a("precache_delimiters", ")]', ");
        C0 = a("ad_resource_caching_enabled", bool2);
        D0 = a("resource_cache_prefix", "https://vid.applovin.com/,https://stage-vid.applovin.com/,https://pdn.applovin.com/,https://stage-pdn.applovin.com/,https://img.applovin.com/,https://stage-img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://stage-assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://stage-vid.applovin.com/,http://pdn.applovin.com/,http://stage-pdn.applovin.com/,http://img.applovin.com/,http://stage-img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://stage-assets.applovin.com/,http://cdnjs.cloudflare.com/,http://u.appl.vn/,https://u.appl.vn/,https://res.applovin.com/,https://res1.applovin.com/,https://res2.applovin.com/,https://res3.applovin.com/,http://res.applovin.com/,http://res1.applovin.com/,http://res2.applovin.com/,http://res3.applovin.com/");
        E0 = a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");
        F0 = a("resource_max_filename_length", 255);
        G0 = a("dfirf", bool);
        H0 = a("dfipf", bool);
        I0 = a("dcrome", bool);
        J0 = a("dcrobs", bool);
        K0 = a("pcro", bool);
        L0 = a("serfaad", bool);
        M0 = a("mdafra", 1);
        N0 = a("ssch", bool2);
        O0 = a("suaf", bool);
        P0 = a("lfblrs", bool);
        Q0 = a("ape", bool);
        R0 = a("pafqi", bool);
        TimeUnit timeUnit3 = TimeUnit.MINUTES;
        S0 = a("pae_ms", Long.valueOf(timeUnit3.toMillis(5L)));
        T0 = a("pamttl_ms", Long.valueOf(timeUnit.toMillis(5L)));
        U0 = a("saewib", bool);
        V0 = a("fsae_ms", -1L);
        W0 = a("raae", bool);
        X0 = a("vr_retry_count_v1", 1);
        Y0 = a("cr_retry_count_v1", 1);
        Z0 = a("text_incent_warning_title", "Attention!");
        f5593a1 = a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");
        f5600b1 = a("text_incent_warning_close_option", "Close");
        f5608c1 = a("text_incent_warning_continue_option", "Keep Watching");
        f5616d1 = a("close_button_touch_area", 0);
        f5624e1 = a("close_button_outside_touch_area", 0);
        f5632f1 = a("creative_debugger_enabled", bool2);
        f5640g1 = a("smdfhcdb", bool2);
        f5648h1 = a("use_background_view_for_ad_clicks", bool2);
        f5656i1 = a("viewability_adview_imp_delay_ms", Long.valueOf(timeUnit.toMillis(1L)));
        f5664j1 = a("viewability_adview_banner_min_width", Integer.valueOf(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE));
        f5672k1 = a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        f5680l1 = a("viewability_adview_mrec_min_width", Integer.valueOf(maxAdFormat.getSize().getWidth()));
        f5688m1 = a("viewability_adview_mrec_min_height", Integer.valueOf(maxAdFormat.getSize().getHeight()));
        f5696n1 = a("viewability_adview_leader_min_width", 728);
        f5704o1 = a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));
        f5712p1 = a("viewability_adview_native_min_width", 0);
        f5720q1 = a("viewability_adview_native_min_height", 0);
        f5728r1 = a("viewability_adview_min_alpha", Float.valueOf(10.0f));
        f5736s1 = a("viewability_timer_min_visible_ms", Long.valueOf(timeUnit.toMillis(1L)));
        f5744t1 = a("viewability_timer_interval_ms", 100L);
        f5752u1 = a("expandable_close_button_size", 27);
        f5759v1 = a("expandable_h_close_button_margin", 10);
        f5766w1 = a("expandable_t_close_button_margin", 10);
        f5773x1 = a("expandable_lhs_close_button", bool);
        f5780y1 = a("expandable_close_button_touch_area", 0);
        f5787z1 = a("iaad", bool);
        A1 = a("fullscreen_ad_pending_display_state_timeout_ms", Long.valueOf(timeUnit.toMillis(10L)));
        B1 = a("fullscreen_ad_showing_state_timeout_ms", Long.valueOf(timeUnit3.toMillis(2L)));
        C1 = a("lhs_close_button_video", bool);
        D1 = a("close_button_right_margin_video", 4);
        E1 = a("close_button_size_video", 30);
        F1 = a("close_button_top_margin_video", 8);
        G1 = a("video_countdown_clock_margin", 10);
        H1 = a("video_countdown_clock_gravity", 83);
        I1 = a("countdown_clock_size", 32);
        J1 = a("countdown_clock_stroke_size", 4);
        K1 = a("countdown_clock_text_size", 28);
        L1 = a("draw_countdown_clock", bool2);
        M1 = a("inter_display_delay", 200L);
        N1 = a("maximum_close_button_delay_seconds", 999L);
        O1 = a("respect_close_button", bool2);
        P1 = a("lhs_skip_button", bool2);
        Q1 = a("track_app_killed", bool);
        R1 = a("track_ad_duration", bool);
        S1 = a("track_ad_duration_interval_ms", Long.valueOf(timeUnit.toMillis(1L)));
        T1 = a("simplified_app_killed_detection", bool);
        U1 = a("app_closed_time_threshold_for_app_killed_event_ms", Long.valueOf(timeUnit.toMillis(60L)));
        V1 = a("mute_controls_enabled", bool);
        W1 = a("allow_user_muting", bool2);
        X1 = a("mute_videos", bool);
        Y1 = a("show_mute_by_default", bool);
        Z1 = a("mute_with_user_settings", bool2);
        f5594a2 = a("mute_button_size", 32);
        f5601b2 = a("mute_button_margin", 10);
        f5609c2 = a("mute_button_gravity", 85);
        f5617d2 = a("progress_bar_step", 25L);
        f5625e2 = a("progress_bar_scale", 10000);
        f5633f2 = a("progress_bar_vertical_padding", -8);
        f5641g2 = a("vs_buffer_indicator_size", 50);
        f5649h2 = a("video_zero_length_as_computed", bool);
        f5657i2 = a("set_poststitial_muted_initial_delay_ms", 500L);
        f5665j2 = a("fasuic", bool2);
        f5673k2 = a("fsahrpg", bool2);
        f5681l2 = a("eaafrwsoa", bool2);
        f5689m2 = a("postitial_progress_bar_step_ms", 25L);
        f5697n2 = a("postitial_progress_bar_on_bottom", bool2);
        f5705o2 = a("postitial_progress_bar_vertical_padding", -8);
        f5713p2 = a("postitial_progress_bar_scale", 10000);
        f5721q2 = a("fahosu", bool);
        f5729r2 = a("sasip", bool);
        f5737s2 = a("system_insets_mask", Integer.valueOf(z6.f()));
        f5745t2 = a("nsuttcl", bool);
        f5753u2 = a("submit_postback_timeout", Integer.valueOf((int) timeUnit.toMillis(10L)));
        f5760v2 = a("submit_postback_retries", 4);
        f5767w2 = a("max_postback_attempts", 3);
        f5774x2 = a("max_persisted_postbacks", 100);
        f5781y2 = a("submit_web_tracker_timeout", Integer.valueOf((int) timeUnit.toMillis(7L)));
        f5788z2 = a("sossp", bool);
        A2 = a("spp", bool2);
        B2 = a("fire_native_ad_postbacks_from_webview", bool);
        C2 = a("use_requests_for_native_ad_click_postbacks", bool);
        D2 = a("preload_postback_webview", bool);
        E2 = a("get_retry_delay_v1", Integer.valueOf((int) timeUnit.toMillis(10L)));
        F2 = a("http_connection_timeout", Integer.valueOf((int) timeUnit.toMillis(30L)));
        G2 = a("http_socket_timeout", Integer.valueOf((int) timeUnit.toMillis(20L)));
        H2 = a("force_ssl", bool);
        I2 = a("fetch_ad_connection_timeout", Integer.valueOf((int) timeUnit.toMillis(30L)));
        J2 = a("fetch_ad_retry_count_v1", 1);
        K2 = a("faer", bool);
        L2 = a("faroae", bool);
        M2 = a("submit_data_retry_count_v1", 1);
        N2 = a("response_buffer_size", 16000);
        O2 = a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) timeUnit.toMillis(10L)));
        P2 = a("fetch_basic_settings_retry_count", 3);
        Q2 = a("fetch_basic_settings_on_reconnect", bool);
        R2 = a("skip_fetch_basic_settings_if_not_connected", bool);
        S2 = a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) timeUnit.toMillis(2L)));
        T2 = a("idflrwbe", bool);
        U2 = a("falawpr", bool);
        V2 = a("sort_query_parameters", bool);
        W2 = a("communicator_request_timeout_ms", Long.valueOf(timeUnit.toMillis(10L)));
        X2 = a("communicator_request_retry_count", 3);
        Y2 = a("communicator_request_retry_delay_ms", Long.valueOf(timeUnit.toMillis(2L)));
        Z2 = a("rfbsd_ms", -1L);
        f5595a3 = a("ehkpd_ms", 500L);
        f5602b3 = a("rironc", bool);
        f5610c3 = a("rroncbd", bool);
        f5618d3 = a("wverc_ms", Long.valueOf(timeUnit.toMillis(5L)));
        f5626e3 = a("sducifm", bool);
        f5634f3 = a("ad_session_minutes", 60);
        f5642g3 = a("session_tracking_cooldown_on_event_fire", bool2);
        f5650h3 = a("session_tracking_resumed_cooldown_minutes", 90L);
        f5658i3 = a("session_tracking_paused_cooldown_minutes", 90L);
        f5666j3 = a("qq", bool);
        f5674k3 = a("qq1", bool2);
        f5682l3 = a("qq2", bool2);
        f5690m3 = a("qq3", bool2);
        f5698n3 = a("qq4", bool2);
        f5706o3 = a("qq5", bool2);
        f5714p3 = a("qq6", bool2);
        f5722q3 = a("qq7", bool2);
        f5730r3 = a("qq8", bool2);
        f5738s3 = a("qq9", bool);
        f5746t3 = a("qq10", bool2);
        f5754u3 = a("pui", bool2);
        f5761v3 = a("plugin_version", "");
        f5768w3 = a("validate_admob_adapter_sdk_version", bool2);
        f5775x3 = a("ccbtbsic", bool);
        f5782y3 = a("hgn", bool2);
        f5789z3 = a("cso", bool2);
        A3 = a("cfs", bool2);
        B3 = a("cmi", bool2);
        C3 = a("crat", bool2);
        D3 = a("cvs", bool2);
        E3 = a("caf", bool2);
        F3 = a("cf", bool2);
        G3 = a("cmtl", bool2);
        H3 = a("cnr", bool2);
        I3 = a("ccr", bool);
        J3 = a("adr", bool2);
        K3 = a("volume_normalization_factor", Float.valueOf(6.6666665f));
        L3 = a("system_user_agent_collection_enabled", bool);
        M3 = a("user_agent_collection_enabled", bool);
        N3 = a("use_cached_user_agent_as_default", bool2);
        O3 = a("collect_device_angle", bool2);
        P3 = a("collect_device_movement", bool2);
        Q3 = a("movement_degradation", Float.valueOf(0.75f));
        R3 = a("device_sensor_period_ms", 250);
        S3 = a("mps", "");
        T3 = a("mpsl", 3);
        U3 = a(sm.f15319c, "com.applovin,dalvik,java,android,com.android");
        V3 = a("cmps", bool);
        W3 = a("rmps", bool);
        X3 = a("collect_webview_package_info", bool);
        Y3 = a("webview_package_names", "com.google.android.webview,com.android.webview");
        Z3 = a("collect_opengl_version", bool);
        f5596a4 = a("ncre", bool);
        f5603b4 = a("ncrs", "4,5,6,7,8,11,16");
        f5611c4 = a("ncrcs", bool);
        f5619d4 = a("tmas", "");
        f5627e4 = a("cin_v2", bool);
        f5635f4 = a("suia", bool2);
        f5643g4 = a("is_track_ad_info", bool2);
        f5651h4 = a("umsm", bool);
        f5659i4 = a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");
        f5667j4 = a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");
        f5675k4 = a("vast_max_response_length", 640000);
        f5683l4 = a("vast_max_wrapper_depth", 5);
        f5691m4 = a("vast_unsupported_video_extensions", "ogv,flv");
        f5699n4 = a("vast_unsupported_video_types", "video/ogg,video/x-flv");
        f5707o4 = a("vast_validate_with_extension_if_no_video_type", bool2);
        f5715p4 = a("vast_wrapper_resolution_retry_count_v1", 1);
        f5723q4 = a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) timeUnit.toMillis(30L)));
        f5731r4 = a("vast_industry_icon_max_size", 20);
        f5739s4 = a("vast_industry_icon_margin", 12);
        f5747t4 = a("vast_industry_icon_gravity", 85);
        f5755u4 = a("vast_native_mute_button_size", 24);
        f5762v4 = a("vast_native_play_pause_button_size", 24);
        f5769w4 = a("vast_native_video_widget_padding", 6);
        f5776x4 = a("vast_native_video_widget_alpha", Float.valueOf(0.5f));
        f5783y4 = a("vast_native_video_widgets_enabled", bool2);
        f5790z4 = a("vast_replay_video_upon_completion", bool2);
        A4 = a("vast_replay_icon_size", 64);
        B4 = a("vcjfhr", bool);
        C4 = a("vcjfhrr", "(?:<|%3C)script[^>]*src=\"(https[^\"]*\\.js[^\"]*)\".*?(?:>|%3E)");
        D4 = a("vpenfxr", "(<Error><!\\[CDATA\\[[^>]*><\\/Error>)");
        E4 = a("vast_fire_trackers_from_webview", bool);
        F4 = a("ree", bool2);
        i4.a aVar = i4.a.DEFAULT;
        G4 = a("ree_t", Integer.valueOf(aVar.b()));
        H4 = a("btee", bool2);
        I4 = a("btet", Integer.valueOf(aVar.b()));
        J4 = a("reetoa", bool);
        K4 = a("reet_msfs", Integer.valueOf(aVar.b()));
        L4 = a("reet_msma", Integer.valueOf(i4.a.V2.b()));
        M4 = a("reet_msmd", Integer.valueOf(aVar.b()));
        N4 = a("reet_asfp", Integer.valueOf(aVar.b()));
        O4 = a("reet_asfg", Integer.valueOf(aVar.b()));
        P4 = a("reet_aset", Integer.valueOf(aVar.b()));
        Q4 = a("reet_esdi", Integer.valueOf(aVar.b()));
        R4 = a("reet_esrp", Integer.valueOf(aVar.b()));
        S4 = a("apdra", bool);
        T4 = a("apdrfs", bool);
        U4 = a("apdrma", bool);
        V4 = a("apdrmd", bool);
        W4 = a("apdrfa", bool);
        X4 = a("apdrev", bool);
        Y4 = a("apdrdi", bool);
        Z4 = a("apdrrp", bool);
        f5597a5 = a("server_timestamp_ms", 0L);
        f5604b5 = a("device_timestamp_ms", 0L);
        f5612c5 = a("gzip_min_length", 0);
        f5620d5 = a("gzip_encoding_default", bool);
        f5628e5 = a("fetch_settings_gzip", bool);
        f5636f5 = a("device_init_gzip", bool);
        f5644g5 = a("fetch_ad_gzip", bool);
        f5652h5 = a("event_tracking_gzip", bool);
        f5660i5 = a("reward_postback_gzip", bool);
        f5668j5 = a("handle_render_process_gone", bool2);
        f5676k5 = a("rworpg", bool2);
        f5684l5 = a("fdadaomr", bool2);
        f5692m5 = a("vfswccar", bool);
        f5700n5 = a("sparafad", bool);
        f5708o5 = a("fahctdmr", bool);
        f5716p5 = a("teorpc", bool);
        f5724q5 = a("set_webview_render_process_client", bool);
        f5732r5 = a("disable_webview_hardware_acceleration", bool);
        f5740s5 = a("anr_detection_enabled", bool);
        f5748t5 = a("anr_trigger_millis", 4000L);
        f5756u5 = a("anr_touch_millis", Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS));
        f5763v5 = a("anr_check_millis", Long.valueOf(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS));
        f5770w5 = a("uobid", bool2);
        f5777x5 = a("bvde", bool);
        f5784y5 = a("bvdidm", 1000L);
        f5791z5 = a("bvdim", 4000L);
        A5 = a("bvdrs", 10);
        B5 = a("bvdct", 230);
        C5 = a("bvdict", 3);
        D5 = a("bvad", bool);
        E5 = a("bvebb", bool2);
        F5 = a("bvscb", bool2);
        G5 = a("bvlmtb", -1L);
        H5 = a("bvsafw", bool2);
        I5 = a("aocve", bool);
        J5 = a("dwvvb", bool);
        K5 = a("stcpc", bool);
        L5 = a("stcic", bool2);
        M5 = a("qjscwwvl", bool);
        N5 = a("web_contents_debugging_enabled", bool);
        O5 = a("fcioiauiidb", bool2);
        P5 = a("teouauiidb", bool2);
        Q5 = a("usc", bool);
        R5 = a("should_apply_web_view_settings_to_web_view_button", bool);
        S5 = a("should_use_cached_screen_size_for_foldable_devices", bool2);
        T5 = a("should_persist_shared_prefs_with_background_commit", bool);
        U5 = a("wvmldt", -1);
        V5 = a("fmldt", -1);
        W5 = a("csl", -1);
        X5 = a("should_use_applovin_adaptive_sizing_formula", bool);
        Y5 = a("cdbpn", bool);
        Z5 = a("sudbia", bool);
        f5598a6 = a("pbpn", "");
        f5605b6 = a("config_consent_dialog_state", "unknown");
        f5613c6 = a(Geo.JsonKeys.COUNTRY_CODE, "");
        f5621d6 = a("approved_installers_for_package_name_override", "com.google.android.packageinstaller");
        f5629e6 = a("consent_flow_doc_url", "https://developers.applovin.com/en/android/overview/terms-and-privacy-policy-flow");
        f5637f6 = a("consent_flow_unity_doc_url", "https://developers.applovin.com/en/unity/overview/terms-and-privacy-policy-flow");
        f5645g6 = a("cfadtml", 20);
        f5653h6 = a("enable_custom_tabs_service", bool2);
        f5661i6 = a("custom_tabs_chrome_package_names", "com.android.chrome");
        f5669j6 = a("custom_tabs_prefer_default_browser", bool2);
        f5677k6 = a("custom_tabs_animation_enabled", bool2);
        f5685l6 = a("ps_etr", bool);
        f5693m6 = a("ps_tri_ms", Long.valueOf(timeUnit2.toMillis(7L)));
        f5701n6 = a("ps_ftri_ms", -1L);
        f5709o6 = a("ps_sroftr", bool);
        f5717p6 = a("ps_sroftrof", bool);
        f5725q6 = a("gawvbu", "https://applovin.com");
        f5733r6 = a("c_sticky_topics", "safedk_init,user_info");
        f5741s6 = a("communicator_enabled", bool2);
        f5749t6 = a("adse", bool2);
    }

    public l4(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        }
        if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        }
        this.f5792a = str;
        this.f5793b = obj;
    }

    public static Collection c() {
        return Collections.synchronizedCollection(f5614d.values());
    }

    public Object a() {
        return this.f5793b;
    }

    public String b() {
        return this.f5792a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof l4)) {
            return 0;
        }
        return this.f5792a.compareTo(((l4) obj).b());
    }

    public Object a(Object obj) {
        return this.f5793b.getClass().cast(obj);
    }

    protected static l4 a(String str, Object obj) {
        if (obj != null) {
            if (f5606c.contains(obj.getClass())) {
                l4 l4Var = new l4(str, obj);
                Map map = f5614d;
                if (!map.containsKey(str)) {
                    map.put(str, l4Var);
                    return l4Var;
                }
                throw new IllegalArgumentException("Setting has already been used: " + str);
            }
            throw new IllegalArgumentException("Unsupported value type: " + obj.getClass());
        }
        throw new IllegalArgumentException("No default value specified");
    }
}
