public enum Major {
        BAIT("33:136", "RBS"),
        CS("01:198", "SAS"),
        MATH("01:640", "SAS"),
        ITI("04:547", "SC&I"),
        EE("14:332", "SOE");

        private final String majorCode;
        private final String schoolName;

        Major(String majorCode, String schoolName) {
            this.majorCode = majorCode;
            this.schoolName = schoolName;
        }

}