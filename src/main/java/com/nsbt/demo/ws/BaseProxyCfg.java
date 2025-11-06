package com.nsbt.demo.ws;

public abstract class BaseProxyCfg {

    String endpoint;
    String username;
    String password;
    String timeout;

    // GETTERS & SETTERS //

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(final String timeout) {
        this.timeout = timeout;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseProxyCfg [endpoint=");
        builder.append(endpoint);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", timeout=");
        builder.append(timeout);
        builder.append("]");
        return builder.toString();
    }

}