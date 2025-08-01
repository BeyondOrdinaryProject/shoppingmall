package BOproject.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BOproject.dao.AiContentDao;
import BOproject.model.AiContentVO;
import BOproject.util.ConnectionUtil;

public class AiContentDaoImpl implements AiContentDao{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AiContentDaoImpl() {
		conn = ConnectionUtil.getConnectionUtil().getConnection();
	}
	
	@Override
	public List<AiContentVO> listAiContent() throws SQLException {
		String sql = " select aicon_id, aicon_user_id, aicontent, aicontenturl, aicontentdate from bo.aicontent ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<AiContentVO> aiContentList = new ArrayList<AiContentVO>();
		if(rs!=null) {
			while(rs.next()) {
				AiContentVO aiContent = new AiContentVO();
				aiContent.setAiCon_Id(rs.getInt("aicon_id"));
				aiContent.setAiCon_user_Id(rs.getString("aicon_user_id"));
				aiContent.setAiContent(rs.getString("aicontent"));
				aiContent.setAiContentUrl(rs.getString("aicontenturl"));
				aiContent.setAiContentDate(rs.getTimestamp("aicontentdate"));
				aiContentList.add(aiContent);
			}
		}
		return aiContentList;
	}
	
	@Override
	public AiContentVO getAiContent(int aiCon_Id) throws SQLException {
		String sql = " select aicon_id, aicon_user_id, aicontent, aicontenturl, aicontentdate from bo.aicontent where aicon_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aiCon_Id);
		rs = pstmt.executeQuery();
		AiContentVO aiContent = new AiContentVO();
		if(rs!=null) {
			if(rs.next()) {
				aiContent.setAiCon_Id(rs.getInt("aicon_id"));
				aiContent.setAiCon_user_Id(rs.getString("aicon_user_id"));
				aiContent.setAiContent(rs.getString("aicontent"));
				aiContent.setAiContentUrl(rs.getString("aicontenturl"));
				aiContent.setAiContentDate(rs.getTimestamp("aicontentdate"));
			}
		}
		return aiContent;
	}
	
	@Override
	public int registAiContent(AiContentVO aiContent) throws SQLException {
			String sql = " insert into bo.aicontent values(seq_aicontent.nextval, ?, ?, ?, sysdate) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aiContent.getAiCon_user_Id());
			pstmt.setString(2, aiContent.getAiContent());
			pstmt.setString(3, aiContent.getAiContentUrl());
			return pstmt.executeUpdate();
	}

	@Override
	public int modifyAiContent(AiContentVO aiContent) throws SQLException {
		String sql = " update bo.aicontent set aicontent=?, aicontentdate=sysdate where aicon_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, aiContent.getAiContent());
		pstmt.setInt(2, aiContent.getAiCon_Id());
		return pstmt.executeUpdate();
	}

	@Override
	public int removeAiContent(int aiCon_Id) throws SQLException {
		String sql = " delete bo.aicontent where aicon_id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aiCon_Id);
		return pstmt.executeUpdate();
	}
	
}






















