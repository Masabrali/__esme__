import React from "react";

import favicon from "../static/img/favicon.png";


export default function Base(props) {
    // <!-- Page container -->
    return (
        <div className="container full-width no-margin no-padding body-container d-flex flex-column">
            <header className="header position-fixed start-0 end-0 z-index-3 shadow-sm">
                <div className="container header-container d-flex flex-row justify-content-between align-items-center overflow-y-visibl py-2">
                    <a className="text-decoration-none d-block logo-container d-flex flex-row justify-content-start align-items-center flex-fill">
                        <img src={ favicon } width="34" height="28" />
                        <p class="fw-bold mb-0 header-logo-text ms-1">eSME</p>
                    </a>
                    <div className="d-flex flex-row justify-content-end align-items-center overflow-y-visibl">
                        { props.renderNav && props.renderNav(props) }
                    </div>
                </div>
            </header>
            <main className="content flex-fill">
                <div className="jumbotron flex-fill h-100">
                    <div className="container cover flex-fill h-100">
                        <div className="container content-container d-flex flex-column justify-content-center align-items-center h-100">
                            <div className="content-wrapper d-flex flex-column justify-content-center align-items-center">
                                { props.children }
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <footer className="footer">
                <div className="container footer-container pt-3 mx-auto">
                    <div className="row mt-3 mb-4"></div>
                    <p className="copyright text-white my-4 px-3">&copy; 2024 <strong>eSME</strong>, All Rights Reserved.</p>
                </div>
            </footer>
        </div>
    );
}