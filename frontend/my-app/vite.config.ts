import ssr from "vike/plugin";
import react from "@vitejs/plugin-react";
import { defineConfig } from "vite";
import basicSsl from "@vitejs/plugin-basic-ssl";

export default defineConfig({
  plugins: [react({}), ssr({}),
  basicSsl({
    name: 'test',
    domains: ['localhost'],
    certDir: './ssl-localhost'
  })
  ],
});