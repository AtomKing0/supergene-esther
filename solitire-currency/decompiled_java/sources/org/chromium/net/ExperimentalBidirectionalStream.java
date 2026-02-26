package org.chromium.net;

import org.chromium.net.BidirectionalStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    public static abstract class Builder extends BidirectionalStream.Builder {
        @Override // org.chromium.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String str, String str2);

        @Override // org.chromium.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // org.chromium.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean z10);

        @Override // org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String str);

        @Override // org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int i10);

        public Builder addRequestAnnotation(Object obj) {
            return this;
        }

        public Builder setTrafficStatsTag(int i10) {
            return this;
        }

        public Builder setTrafficStatsUid(int i10) {
            return this;
        }
    }
}
