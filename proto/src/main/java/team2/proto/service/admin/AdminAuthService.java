package team2.proto.service.admin;

import team2.proto.dto.admin.AdminAuthDTO;
import team2.proto.entity.AdminPage;

import java.util.List;

public interface AdminAuthService {

    public List<AdminAuthDTO> getAllAuthList();

    public Integer updateAuth(Long authNo, boolean approve);

    public Integer updateAdmin(Long adminNo, boolean adminApprove);

}