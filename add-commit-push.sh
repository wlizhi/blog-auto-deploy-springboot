git add .
git commit -m cc
git push origin master
if test 'github' = $1; then
echo 'push to origin-github master...'
git push origin-github master
echo 'push to origin-github master successful.'
fi