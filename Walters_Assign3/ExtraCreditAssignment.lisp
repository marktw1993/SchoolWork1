(defun prime-test (n m)
	(if (= n m) T
	(if (=(float(/ n m))(round(/ n m))) ()
	(prime-test n (+ 1 m)))))	

(defun find-primes(n)
    (cond((= n 2)(append (list 2)))
    ((cond((null(prime-test n 2))(find-primes(- n 1)))
    ((append(list n)(find-primes(- n 1))))))))	

(defun even-prime-sums (n)
  (write-line " ")
  (write-line " ")
   (dolist(a (find-primes n))
     (dolist(b (find-primes n))
		(if (= n (+ a b))
		   (format t "~d + ~d = ~d~%" b a n)))))

(even-prime-sums 102)