import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// 상대 경로 base('./')로 로컬 dev와 서브패스 배포(/supergene-esther/city2048/) 모두 대응.
// 라이브러리 청크 분리는 원본 배포 구조(react-vendor / pixi)를 따름.
export default defineConfig({
  base: "./",
  plugins: [react()],
  build: {
    outDir: "dist",
    rollupOptions: {
      output: {
        manualChunks: {
          "react-vendor": ["react", "react-dom"],
          pixi: ["pixi.js", "@pixi/sound"],
        },
      },
    },
  },
});
