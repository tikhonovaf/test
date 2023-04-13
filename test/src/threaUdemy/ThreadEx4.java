////@Service
//@RequiredArgsConstructor
//public class EmployeeProcessor {
//
//    private final FileSystemClient fileSystemClient;
//    private final EmployeeFileProcessor employeeFileProcessor;
//    private final EmployeeDao employeeDao;
//    private final SalaryInfoDao salaryInfoDao;
//    @Value("${employee-upload.read-dir-path}")
//    private String readFilePath;
//
//    @Scheduled(fixedRateString = "${employee-upload.read-period-ms}")
//    public void run() throws IOException {
//        InputStream fileIs = fileSystemClient.getFile(readFilePath);
//        String employeeTxtFile = new String(IOUtils.toByteArray(fileIs), StandardCharsets.UTF_8);
//        List<EmployeeInfo> employees = employeeFileProcessor.getEmployeesFromFile(employeeTxtFile);
//        for (EmployeeInfo employeeInfo : employees) {
//            processEmployee(employeeInfo);
//        }
//    }
//
//    @Transactional
//    private void processEmployee(EmployeeInfo employeeInfo) {
//        if (!employeeDao.isExist(employeeInfo.getEmployeeId())) {
//            employeeDao.save(employeeInfo);
//            salaryInfoDao.save(employeeInfo);
//        }
//    }
//
//}
//
