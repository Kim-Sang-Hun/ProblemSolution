-- 코드를 입력하세요
SELECT A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT P JOIN APPOINTMENT A ON P.PT_NO = A.PT_NO
JOIN DOCTOR D ON A.MDDR_ID = D.DR_ID
WHERE A.MCDP_CD = 'CS'
AND DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13'
AND (APNT_CNCL_YN = 'N' OR (APNT_CNCL_YN = 'Y' AND APNT_CNCL_YMD > '2022-04-13'))
ORDER BY APNT_YMD