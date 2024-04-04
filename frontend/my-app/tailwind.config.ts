import type { Config } from "tailwindcss";

export default {
  content: ["./{pages,layouts,components,src,assets}/**/*.{html,js,jsx,ts,tsx,vue}"],
  theme: {
    extend: {},
  },
  plugins: [require("@tailwindcss/typography"), require("daisyui")],
  daisyui: {
    themes: ["emerald", "light", "dark", "dracula"],
  },
} satisfies Config;
