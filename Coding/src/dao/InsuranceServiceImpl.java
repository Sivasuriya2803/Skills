package dao;
import Connect.DataConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import Model.Policy;


public class InsuranceServiceImpl implements IPolicyService{
    public boolean createPolicy(Policy policy) {
        String sql = "INSERT INTO policies (policyId, policyName, policyDetails) VALUES (?, ?, ?)";
        try (Connection connection = DataConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, policy.getPolicyId());
            preparedStatement.setString(2, policy.getPolicyName());
            preparedStatement.setString(3, policy.getPolicyDetails());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Policy getPolicy(int policyId) {
        String sql = "SELECT * FROM policies WHERE policyId = ?";
        try (Connection connection = DataConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, policyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Policy(
                        resultSet.getInt("policyId"),
                        resultSet.getString("policyName"),
                        resultSet.getString("policyDetails")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        List<Policy> policies = new ArrayList<>();
        String sql = "SELECT * FROM policies";
        try (Connection connection = DataConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                policies.add(new Policy(
                        resultSet.getInt("policyId"),
                        resultSet.getString("policyName"),
                        resultSet.getString("policyDetails")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String sql = "UPDATE policies SET policyName = ?, policyDetails = ? WHERE policyId = ?";
        try (Connection connection = DataConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, policy.getPolicyName());
            preparedStatement.setString(2, policy.getPolicyDetails());
            preparedStatement.setInt(3, policy.getPolicyId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        String sql = "DELETE FROM policies WHERE policyId = ?";
        try (Connection connection = DataConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, policyId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
