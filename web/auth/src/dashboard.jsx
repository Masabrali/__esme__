import { useAuth } from "react-oidc-context";
import { redirect, useNavigate } from "react-router";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarAlt, faCookie, faWallet } from "@fortawesome/free-solid-svg-icons";

export default function Dashboard() {
    const navigate = useNavigate();
    const auth = useAuth();

    if (!auth.isAuthenticated) {
        navigate("/");
    }

    const logout = () => {
        sessionStorage.clear();
        // faCookie.removeAll();
        navigate("/");
    };

    return (
        <div style={styles.container}>
            {/* Header Card */}
            <div style={styles.headerCard}>
                <h1 style={styles.title}>
                    Welcome, {auth.user?.profile.sub}
                </h1>
                <button
                    style={styles.logoutButton}
                    onClick={() => logout()}
                >
                    Log out
                </button>
            </div>

            {/* Body Cards */}
            <div style={styles.body}>
                <div style={styles.card} className="card">
                    <FontAwesomeIcon
                        icon={faCalendarAlt}
                        style={styles.icon}
                    />
                    <h2>Calendar</h2>
                    <p>Manage your schedule efficiently.</p>
                </div>
                <div style={styles.card} className="card">
                    <FontAwesomeIcon
                        icon={faWallet}
                        style={styles.icon}
                    />
                    <h2>Expense</h2>
                    <p>Track and manage your expenses.</p>
                </div>
            </div>
        </div>
    );
}

const styles = {
    container: {
        height: "100vh",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#f7f8fc",
        color: "#333",
        padding: "1rem",
    },
    headerCard: {
        backgroundColor: "#fff",
        padding: "2rem",
        borderRadius: "8px",
        boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
        width: "500px",
        textAlign: "center",
        marginBottom: "2rem",
        transition: "transform 0.3s ease",
    },
    card: {
        backgroundColor: "#fff",
        padding: "1.5rem",
        borderRadius: "8px",
        boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
        width: "200px",
        textAlign: "center",
        transition: "transform 0.3s ease, box-shadow 0.3s ease",
        cursor: "pointer",
    },
    title: {
        fontSize: "1.8rem",
        margin: 0,
        marginBottom: "1rem",
    },
    logoutButton: {
        padding: "0.5rem 1rem",
        fontSize: "1rem",
        color: "#fff",
        backgroundColor: "#6200ea",
        border: "none",
        borderRadius: "5px",
        cursor: "pointer",
        transition: "background-color 0.3s ease",
    },
    body: {
        display: "flex",
        gap: "1.5rem",
        justifyContent: "center",
        alignItems: "center",
        width: "100%",
        flexWrap: "wrap",
    },
    icon: {
        fontSize: "2rem",
        color: "#6200ea",
        marginBottom: "0.5rem",
    },
};
