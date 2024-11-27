import React from "react";
import { AuthProvider, useAuth } from "react-oidc-context";

import { createRoot } from "react-dom/client";
import { BrowserRouter, Route, Routes } from "react-router";
import App from "./src/app";
import "./index.css";
import Dashboard from "./src/dashboard";


const oidcConfig = {
    authority: "http://localhost:8093",
    client_id: "client",
    redirect_uri: "http://localhost:1234/dashboard",
};

const rootElement = document.getElementById("root");

if (!rootElement) throw new Error("Failed to find the root element");
const root = createRoot(rootElement);

root.render(
    <AuthProvider {...oidcConfig}>
        <BrowserRouter>
        <Routes>
            <Route path="/" element={<App />}/>
            <Route path="/dashboard" element={<Dashboard />} />
        </Routes>
    </BrowserRouter>
    </AuthProvider>,
);