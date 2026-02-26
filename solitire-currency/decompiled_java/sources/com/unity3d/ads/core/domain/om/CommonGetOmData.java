package com.unity3d.ads.core.domain.om;

import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: CommonGetOmData.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGetOmData implements GetOmData {

    @NotNull
    private final OpenMeasurementRepository openMeasurementRepository;

    public CommonGetOmData(@NotNull OpenMeasurementRepository openMeasurementRepository) {
        t.i(openMeasurementRepository, "openMeasurementRepository");
        this.openMeasurementRepository = openMeasurementRepository;
    }

    @Override // com.unity3d.ads.core.domain.om.GetOmData
    @Nullable
    public Object invoke(@NotNull d<? super OMData> dVar) {
        return this.openMeasurementRepository.getOmData();
    }
}
