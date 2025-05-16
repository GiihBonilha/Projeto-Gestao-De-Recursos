public List<Equipamento> listar() throws SQLException {
    List<Equipamento> lista = new ArrayList<>();
    String sql = "SELECT * FROM equipamentos";
    try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Equipamento equipamento = new Equipamento();
            equipamento.setId(rs.getLong("id"));
            equipamento.setNumeroTombo(rs.getString("numero_tombo"));
            equipamento.setEquipamento(rs.getString("equipamento"));
            equipamento.setMarca(rs.getString("marca"));
            equipamento.setModelo(rs.getString("modelo"));
            lista.add(equipamento);
        }
    }
    return lista;
}

public Equipamento consultar(long id) throws SQLException {
    String sql = "SELECT * FROM equipamentos WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(rs.getLong("id"));
                equipamento.setNumeroTombo(rs.getString("numero_tombo"));
                equipamento.setEquipamento(rs.getString("equipamento"));
                equipamento.setMarca(rs.getString("marca"));
                equipamento.setModelo(rs.getString("modelo"));
                return equipamento;
            }
        }
    }
    return null; // Retorna null caso não encontre
}

public void alterar(Equipamento equipamento) throws SQLException {
    String sql = "UPDATE equipamentos SET numero_tombo = ?, equipamento = ?, marca = ?, modelo = ? WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, equipamento.getNumeroTombo());
        stmt.setString(2, equipamento.getEquipamento());
        stmt.setString(3, equipamento.getMarca());
        stmt.setString(4, equipamento.getModelo());
        stmt.setLong(5, equipamento.getId());
        stmt.executeUpdate();
    }
}

public void excluir(long id) throws SQLException {
    String sql = "DELETE FROM equipamentos WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        stmt.executeUpdate();
    }
}
