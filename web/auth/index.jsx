import React from "react";
import { AuthProvider, useAuth } from "react-oidc-context";
import { createRoot } from "react-dom/client";
import App from './src/App';


const oidcConfig = {
    authority: "http://localhost:8093",
    client_id: "client",
    redirect_uri: "http://localhost:1234",
};

const rootElement = document.getElementById("root");

if (!rootElement) throw new Error("Failed to find the root element");
const root = createRoot(rootElement);

root.render(
    <AuthProvider {...oidcConfig}>
        <App />
    </AuthProvider>,
);