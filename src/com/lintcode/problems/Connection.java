package com.lintcode.problems;

public class Connection {
    public String city1, city2;
    public int cost;
    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city1 == null) ? 0 : city1.hashCode());
        result = prime * result + ((city2 == null) ? 0 : city2.hashCode());
        result = prime * result + cost;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Connection other = (Connection) obj;
        if (city1 == null) {
            if (other.city1 != null)
                return false;
        } else if (!city1.equals(other.city1))
            return false;
        if (city2 == null) {
            if (other.city2 != null)
                return false;
        } else if (!city2.equals(other.city2))
            return false;
        if (cost != other.cost)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[\"" + city1 + "\", \"" + city2 + "\", " + cost + "]";
    }
}
